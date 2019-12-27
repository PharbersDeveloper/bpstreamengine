package com.pharbers.StreamEngine.Jobs.SqlTableJob.SqlTableJobContainer

import java.util.UUID
import java.util.concurrent.{Executors, LinkedBlockingQueue, ThreadPoolExecutor, TimeUnit}

import com.pharbers.StreamEngine.Jobs.SqlTableJob.SqlTableListener.{BPSqlTableKafkaListener, BPStreamOverListener}
import com.pharbers.StreamEngine.Utils.Config.BPSConfig
import com.pharbers.StreamEngine.Utils.Event.EventHandler.BPSEventHandler
import com.pharbers.StreamEngine.Utils.Event.StreamListener.BPStreamListener
import com.pharbers.StreamEngine.Utils.StreamJob.JobStrategy.BPSJobStrategy
import com.pharbers.StreamEngine.Utils.StreamJob.{BPDynamicStreamJob, BPSJobContainer, BPStreamJob}
import com.pharbers.StreamEngine.Utils.ThreadExecutor.ThreadExecutor.executorService
import com.pharbers.kafka.schema.HiveTask
import org.apache.kafka.common.config.ConfigDef
import org.apache.kafka.common.config.ConfigDef.{Importance, Type}
import org.apache.spark.sql.SparkSession

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/12/11 10:57
  * @note 一些值得注意的地方
  */
class BPSqlTableJobContainer(val spark: SparkSession, config: Map[String, String]) extends BPSJobContainer with BPDynamicStreamJob{

    override type T = BPSJobStrategy
    override val strategy: BPSJobStrategy = null
    final val TOPIC_CONFIG_KEY = "topic"
    final val TOPIC_CONFIG_DOC = "kafka topic"
    final val RUN_ID_CONFIG_KEY = "runId"
    final val RUN_ID_CONFIG_DOC = "run id"
    val configDef: ConfigDef = new ConfigDef()
            .define(TOPIC_CONFIG_KEY, Type.STRING, "HiveTask", Importance.HIGH, TOPIC_CONFIG_DOC)
            .define(RUN_ID_CONFIG_KEY, Type.STRING, UUID.randomUUID().toString, Importance.HIGH, RUN_ID_CONFIG_DOC)
    private val jobConfig: BPSConfig = BPSConfig(configDef, config)

    val runId: String = jobConfig.getString(RUN_ID_CONFIG_KEY)
    val jobId: String = UUID.randomUUID().toString
    val id: String = runId

    val executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue[Runnable])


    override def open(): Unit = {
        logger.info("open BPSqlTableJobContainer")
    }

    override def exec(): Unit ={
        logger.info("开启BPSqlTableKafkaListener")
        val listener = BPSqlTableKafkaListener(this, jobConfig.getString(TOPIC_CONFIG_KEY))
        listener.active(null)
        listeners = listeners :+ listener
    }

    override def close(): Unit = {
        super.close()
        jobs.foreach(x => x._2.close())
    }

    def addJob2Container(job: BPStreamJob): Unit ={
        executorService.execute(new Runnable{
            override def run(): Unit = {
                job.open()
                job.exec()
            }
        })
        jobs = jobs ++ Map(job.id -> job)
    }

    def hiveTaskHandler(msg: HiveTask): Unit ={
        val url = msg.getUrl.toString
        val path = url.substring(0, url.lastIndexOf("contents"))

        val listenerConfig = Map(
            "runId" -> runId,
            "jobId" -> UUID.randomUUID().toString,
            "url" -> msg.getUrl.toString,
            "length" -> msg.getLength.toString,
            "rowRecordPath" -> (path + "row_record"),
            "metadataPath" -> (path +  "metadata"),
            "errorPath" -> (path +  "err"),
            "taskType" -> msg.getTaskType.toString
        )
        val listener = BPStreamOverListener(this, listenerConfig)
        listener.active(null)
        listeners = listeners :+ listener
    }

    override def registerListeners(listener: BPStreamListener): Unit = {}

    override def handlerExec(handler: BPSEventHandler): Unit = {}
}
