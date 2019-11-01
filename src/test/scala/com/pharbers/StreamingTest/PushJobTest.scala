package com.pharbers.StreamingTest

import java.io.File
import java.util.concurrent.TimeUnit
import com.pharbers.StreamEngine.Utils.Component.Dynamic.JobMsg
import com.pharbers.kafka.producer.PharbersKafkaProducer
import com.pharbers.kafka.schema.BPJob
import org.apache.avro.Schema
import org.apache.avro.generic.{GenericData, GenericRecord}
import org.scalatest.FunSuite

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/10/23 15:01
  * @note 一些值得注意的地方
  */
class PushJobTest extends FunSuite{
    test("push job") {
        import org.json4s._
        import org.json4s.jackson.Serialization.write
        implicit val formats: DefaultFormats.type = DefaultFormats
        val jobId = "201910231514"
        val traceId = "201910231514"
        val `type` = "add"
        val jobs =
                JobMsg("ossStreamJob", "job", "com.pharbers.StreamEngine.Jobs.OssPartitionJob.OssJobContainer.BPSOssPartitionJobContainer", List("$BPSKfkJobStrategy", "$BPSparkSession"), Nil, Nil, Map.empty, "", "oss job") ::
                JobMsg("sandBoxJob", "job", "com.pharbers.StreamEngine.Jobs.SandBoxJob.SandBoxJobContainer.BPSSandBoxJobContainer", List("$BPSparkSession"), Nil, Nil, Map.empty, "", "sandbox job") ::
                Nil
//        val jobMsg = write(JobMsg("testJob", "job", "com.pharbers.StreamEngine.Jobs.OssJob.DynamicJobDemo",
//            List("$BPSparkSession", "$BPSKfkJobStrategy", "demo"), Nil, Nil, Map.empty, "", "test job"))
//        val jobMsg = write(JobMsg("testListener", "listener", "com.pharbers.StreamEngine.Jobs.OssJob.DynamicListenerDemo",
//            Nil, List("testJob"), List("id", "this"), Map.empty, "", "test listener"))
//        val jobMsg = write(JobMsg("testListener2", "listener", "com.pharbers.StreamEngine.Jobs.OssJob.DynamicListenerDemo",
//            List("another listener"), List("testJob"), List("this"), Map.empty, "", "test listener"))
        val jobMsg = write(JobMsg("ossStreamJob", "job", "com.pharbers.StreamEngine.Jobs.OssPartitionJob.OssJobContainer.BPSOssPartitionJobContainer",
            List("$BPSKfkJobStrategy", "$BPSparkSession"), Nil, Nil, Map.empty, "", "test job"))
        val topic = "stream_job_submit"

        val pkp = new PharbersKafkaProducer[String, BPJob]
        val bpJob = new BPJob(jobId, traceId, `type`, jobMsg)
        val fu = pkp.produce(topic, jobId, bpJob)
        println(fu.get(10, TimeUnit.SECONDS))
    }

    test("push jobs") {
        import org.json4s._
        import org.json4s.jackson.Serialization.write
        implicit val formats: DefaultFormats.type = DefaultFormats
        val jobId = "201910231514"
        val traceId = "201910231514"
        val `type` = "addList"
        val jobs = JobMsg("ossStreamJob", "job", "com.pharbers.StreamEngine.Jobs.OssPartitionJob.OssJobContainer.BPSOssPartitionJobContainer", List("$BPSKfkJobStrategy", "$BPSparkSession"), Nil, Nil, Map.empty, "", "oss job") ::
                    JobMsg("sandBoxJob", "job", "com.pharbers.StreamEngine.Jobs.SandBoxJob.SandBoxJobContainer.BPSSandBoxJobContainer", List("$BPSparkSession"), Nil, Nil, Map.empty, "", "sandbox job") ::
                    Nil

        val jobMsg = write(jobs)
        val topic = "stream_job_submit"

        val pkp = new PharbersKafkaProducer[String, BPJob]
        val bpJob = new BPJob(jobId, traceId, `type`, jobMsg)
        val fu = pkp.produce(topic, jobId, bpJob)
        println(fu.get(10, TimeUnit.SECONDS))
    }

    test("stop job"){
        import org.json4s._
        implicit val formats: DefaultFormats.type = DefaultFormats
        val jobId = "201910231514"
        val traceId = "201910231514"
        val `type` = "stop"
        val jobMsg = "testJob"

        val topic = "stream_job_submit"

        val pkp = new PharbersKafkaProducer[String, BPJob]
        val bpJob = new BPJob(jobId, traceId, `type`, jobMsg)
        val fu = pkp.produce(topic, jobId, bpJob)
        println(fu.get(10, TimeUnit.SECONDS))
    }
}
