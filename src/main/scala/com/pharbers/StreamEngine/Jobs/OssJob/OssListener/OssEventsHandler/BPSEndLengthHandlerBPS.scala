package com.pharbers.StreamEngine.Jobs.OssJob.OssListener.OssEventsHandler

import java.util.UUID

import com.pharbers.StreamEngine.Utils.Job.BPStreamJob
import com.pharbers.StreamEngine.Jobs.OssJob.OssListener.BPSOssEndListener
import com.pharbers.StreamEngine.Utils.Event.EventHandler.BPSEventHandler
import com.pharbers.StreamEngine.Utils.Event.BPSEvents
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization.read

case class BPSEndLengthHandlerBPS() extends BPSEventHandler {
    override def exec(job: BPStreamJob)(e: BPSEvents): Unit = {
        // 收到End Length 开始执行结束逻辑
        val qn = "view_" + event2JobId(e)
        val spark = job.spark
        import spark.implicits._
        job.inputStream match {
            case Some(input) => {
                job.outputStream = input.filter($"type" === "SandBox" && $"jobId" === event2JobId(e))
                    .groupBy($"jobId").count()
                    .writeStream
                    .outputMode("update")
                    .format("memory")
                    .queryName(qn)
                    .option("checkpointLocation", "/test/streaming/" + UUID.randomUUID().toString + "/checkpoint")
                    .start() :: job.outputStream

                val el = new BPSOssEndListener(spark, job, qn, event2Length(e))
                el.active(null)
//                job.listeners = el :: job.listeners
            }
            case None => ???
        }
    }

    def event2JobId(e: BPSEvents): String = e.jobId
    def event2Length(e: BPSEvents): Int = {
        implicit val formats = DefaultFormats
        read[BPEndLengthElement](e.data).length
    }

    override def close(): Unit = {}
}

case class BPEndLengthElement(length: Int)
