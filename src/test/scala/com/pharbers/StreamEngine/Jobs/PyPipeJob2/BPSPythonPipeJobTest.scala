package com.pharbers.StreamEngine.Jobs.PyPipeJob2

import com.pharbers.StreamEngine.Jobs.PyPipeJob2.PythonPipeJobContainer.BPSPythonPipeJobContainer
import com.pharbers.StreamEngine.Utils.Component2.{BPSComponentConfig, BPSConcertEntry}
import com.pharbers.StreamEngine.Utils.Event.{BPSEvents, BPSTypeEvents}
import com.pharbers.StreamEngine.Utils.Strategy.Session.Spark.BPSparkSession
import org.scalatest.FunSuite

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2020/07/07 11:19
  * @note 一些值得注意的地方
  */
class BPSPythonPipeJobTest extends FunSuite{
    test("test BPSPythonPipeJob exec"){

        val config = Map(
            "listens" -> "Python-FileMetaData",
            "FileMetaData.msgType" -> "HiveTask-FileMetaData",
            "defaultPartition" -> "4",
            "defaultRetryCount" -> "3",
            "pythonUri" -> "s3a://ph-stream/files/pyclean",
            "pythonBranch" -> "0.1.0"
        )
        val container = new BPSPythonPipeJobContainer(BPSComponentConfig("test", "test BPSPythonPipeJobContainer", Nil, config))
        container.open()
        container.exec()
        val data = Map(
            "jobId" -> "test",
            "mongoId" -> "test",
            "datasetId" -> "test",
            "assetId" -> "test",
            "metadataPath" -> "s3a://ph-stream/jobs/runId_5ef0237cf362980c3a933d71/BPSSandBoxConvertSchemaJob/jobId_schema_job_5ef099d8691cf5000114b6e6/id_4e067e75-f8bf-46a6-879a-b03d9aa51c0c/metadata",
            "filesPath" -> "s3a://ph-stream/jobs/runId_5ef0237cf362980c3a933d71/BPSSandBoxConvertSchemaJob/jobId_schema_job_5ef099d8691cf5000114b6e6/id_4e067e75-f8bf-46a6-879a-b03d9aa51c0c/contents",
            "resultPath" -> "s3a://ph-stream/tmp/testPy"
        )
        container.starJob(BPSTypeEvents(BPSEvents("test", "test", "test", data)))
        Thread.sleep(1000 * 60 * 60)
    }
}
