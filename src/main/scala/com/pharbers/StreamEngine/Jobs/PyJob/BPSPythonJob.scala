package com.pharbers.StreamEngine.Jobs.PyJob

import org.apache.spark.sql
import com.pharbers.StreamEngine.Jobs.PyJob.ForeachWriter.PyCleanSinkHDFS
import com.pharbers.StreamEngine.Utils.Component2.BPSConcertEntry
import com.pharbers.StreamEngine.Utils.Strategy.Blood.BPSSetBloodStrategy
import com.pharbers.StreamEngine.Utils.Strategy.hdfs.BPSHDFSFile
import com.pharbers.StreamEngine.Utils.Strategy.s3a.BPS3aFile
import org.apache.spark.sql.SparkSession
import com.pharbers.StreamEngine.Jobs.PyJob.Py4jServer.BPSPy4jManager
import com.pharbers.StreamEngine.Utils.Job.BPStreamJob
import com.pharbers.StreamEngine.Jobs.PyJob.Listener.BPSProgressListenerAndClose
import com.pharbers.StreamEngine.Utils.Component2
import com.pharbers.StreamEngine.Utils.Event.StreamListener.BPStreamListener
import com.pharbers.StreamEngine.Utils.Job.Status.BPSJobStatus
import com.pharbers.StreamEngine.Utils.Module.bloodModules.BloodModel
import com.pharbers.StreamEngine.Utils.Strategy.BPStrategyComponent
import org.apache.kafka.common.config.ConfigDef

object BPSPythonJob {
    def apply(id: String,
              spark: SparkSession,
              inputStream: Option[sql.DataFrame],
              noticeFunc: (String, Map[String, Any]) => Unit,
              jobCloseFunc: String => Unit,
              jobConf: Map[String, Any]): BPSPythonJob =
        new BPSPythonJob(id, spark, inputStream, noticeFunc, jobCloseFunc, jobConf)
}

/** 执行 Python 的 Job
 *
 * @author clock
 * @version 0.0.1
 * @since 2019/11/6 17:43
 * @node jobConf 可用的配置参数
 * {{{
 *     noticeTopic = "noticeTopic" // job完成后的通知位置
 *
 *     datasetId = ObjectId  // 血统中的唯一标识符
 *     parentsId = ObjectId // 上一步的 datasetId
 *
 *     resultPath = "./jobs/runId/containerId/" // Job 执行后的结果的存放位置, 会自动添加 jobId
 *     lastMetadata = Map("jobId" -> "a", "fileName" -> "b") // 上一步的元数据信息
 *
 *     fileSuffix = "csv" // 存放文件的后缀名
 *     partition = "4" //表示每个 Job 可使用的 spark 分区数，也是可用 Python 的线程数
 *     retryCount = "3" // Job 失败的重试次数
 * }}}
 */
class BPSPythonJob(override val id: String,
                   override val spark: SparkSession,
                   is: Option[sql.DataFrame],
                   noticeFunc: (String, Map[String, Any]) => Unit,
                   jobCloseFunc: String => Unit,
                   jobConf: Map[String, Any]) extends BPStreamJob with Serializable {

    type T = BPStrategyComponent
    override val strategy: BPStrategyComponent = null
    val bloodStrategy: BPSSetBloodStrategy = new BPSSetBloodStrategy(Map.empty)
    val hdfsfile: BPSHDFSFile = BPSConcertEntry.queryComponentWithId("hdfs").get.asInstanceOf[BPSHDFSFile]
    val s3aFile: BPS3aFile = BPSConcertEntry.queryComponentWithId("s3a").get.asInstanceOf[BPS3aFile]
    val noticeTopic: String = jobConf("noticeTopic").toString
    val datasetId: String = jobConf("datasetId").toString
    val assetId: String = jobConf("assetId").toString
    val parentsId: List[String] = jobConf("parentsId").asInstanceOf[List[String]]

    val resultPath: String = {
        val path = jobConf("resultPath").toString
        if (path.endsWith("/")) path + s"jobId_$id"
        else path + "/" + s"jobId_$id"
    }
    val lastMetadata: Map[String, Any] = jobConf("lastMetadata").asInstanceOf[Map[String, Any]]
    val data_length: Long = lastMetadata("length").asInstanceOf[Double].toLong

    val fileSuffix: String = jobConf("fileSuffix").toString
    val partition: Int = jobConf("partition").asInstanceOf[String].toInt
    val retryCount: String = jobConf("retryCount").toString

    val checkpointPath: String = resultPath + "/checkpoint"
    val rowRecordPath: String = resultPath + "/row_record"
    val metadataPath: String = resultPath + "/metadata"
    val successPath: String = resultPath + "/contents"
    val errPath: String = resultPath + "/err"

    override def open(): Unit = {
        regPedigree(BPSJobStatus.Start.toString)
        inputStream = is
    }

    override def exec(): Unit = {
        val py4jManager: BPSPy4jManager = BPSPy4jManager()

        inputStream match {
            case Some(is) =>
                val query = is
                        .writeStream
                        .option("checkpointLocation", checkpointPath)
                        .foreach(PyCleanSinkHDFS(
                            fileSuffix = fileSuffix,
                            retryCount = retryCount,
                            jobId = id,
                            rowRecordPath = rowRecordPath,
                            successPath = successPath,
                            errPath = errPath,
                            metadataPath = metadataPath,
                            lastMetadata = lastMetadata,
                            py4jManager = py4jManager
                        ))
                        .start()

                outputStream = query :: outputStream
                listeners = listeners ::: addListener(rowRecordPath) :: Nil

            case None => ???
        }
    }

    def addListener(rowRecordPath: String): BPStreamListener = {
        val listener = BPSProgressListenerAndClose(this, spark, data_length, rowRecordPath)
        listener.active(null)
        listener
    }

    // 注册血统
    def regPedigree(status: String): Unit = {
       val dfs = BloodModel(
            datasetId,
            assetId,
            parentsId,
            id,
            Nil,
            "",
            data_length,
            successPath,
            "Python 清洗 Job", status)
        
        // TODO 齐 弄出traceId
        bloodStrategy.pushBloodInfo(dfs, id,"")
    }

    override def close(): Unit = {
        regPedigree(BPSJobStatus.End.toString)
        noticeFunc(noticeTopic, Map(
            "jobId" -> id,
            "datasetId" -> datasetId,
            "assetId" -> assetId,
            "length" -> data_length,
            "resultPath" -> resultPath,
            "rowRecordPath" -> rowRecordPath,
            "metadataPath" -> metadataPath,
            "successPath" -> successPath,
            "errPath" -> errPath
        ))
        
        // TODO: 写入HDFS文件上传到S3上
        checkpointPath :: rowRecordPath :: metadataPath :: successPath :: errPath :: Nil foreach {path =>
            hdfsfile.recursiveFiles(path) match {
                case Some(r) =>
                    r.foreach { x =>
                        s3aFile.copyHDFSFiles(s"s3a://ph-stream${x.path}", x.name, x.input)
                    }
                    r.head.fs.close()
                case _ => println("Oops")
            }
        }
    
        
        
        super.close()
        jobCloseFunc(id)
    }

    override val componentProperty: Component2.BPComponentConfig = null

    override def createConfigDef(): ConfigDef = ???

    override val description: String = "py_clean_job"
}
