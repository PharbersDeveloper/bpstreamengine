package com.pharbers.kafka.connect.oss.kafka

import java.util.concurrent.{ExecutionException, Future, TimeUnit, TimeoutException}

import com.pharbers.kafka.connect.oss.model.{BloodMsg, TypeErrorMsg}
import com.pharbers.kafka.connect.utils.JsonUtil
import com.pharbers.kafka.producer.PharbersKafkaProducer
import com.pharbers.kafka.schema.{EventMsg, PhErrorMsg}
import software.amazon.awssdk.auth.credentials.SystemPropertyCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.sqs.model.{MessageAttributeValue, SendMessageRequest}

import collection.JavaConverters._

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/11/26 17:20
  * @note 一些值得注意的地方
  */
private[kafka] class Producer {
    var TOPIC = "oss_msg"
    lazy private val url = "https://sqs.cn-northwest-1.amazonaws.com.cn/444603803904/ph-stream-schedule.fifo"
    lazy val sqsClient: SqsClient = SqsClient.builder().region(Region.of("cn-northwest-1"))
            .credentialsProvider(SystemPropertyCredentialsProvider.create).build()

    def pushErr(msg: TypeErrorMsg): Unit = {
//        val pkp = new PharbersKafkaProducer[String, EventMsg]
        val msgType = "parsingError"
        val attributes = Map(
            "jobId" -> MessageAttributeValue.builder().dataType("String").stringValue(msg.getAssetId).build(),
            "traceId" -> MessageAttributeValue.builder().dataType("String").stringValue(msg.getTraceId).build(),
            "type" -> MessageAttributeValue.builder().dataType("String").stringValue(msgType).build()
        )
        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(url)
                .messageBody(JsonUtil.MAPPER.writeValueAsString(msg))
                .messageAttributes(attributes.asJava)
                .messageGroupId(msg.getAssetId)
                .build())
//        val event = new EventMsg(msg.getAssetId, msg.getTraceId, msgType, JsonUtil.MAPPER.writeValueAsString(msg))
//        val fu = pkp.produce(TOPIC,"", event)
//        try
//            println(fu.get(10, TimeUnit.SECONDS))
//        catch {
//            case e@(_: InterruptedException | _: ExecutionException | _: TimeoutException) =>
//                e.printStackTrace()
//        }
//        pkp.producer.close()
    }

    def pushStatus(msg: BloodMsg, traceId: String): Unit ={

        val attributes = Map(
            "jobId" -> MessageAttributeValue.builder().dataType("String").stringValue(msg.getJobId).build(),
            "traceId" -> MessageAttributeValue.builder().dataType("String").stringValue(traceId).build(),
            "type" -> MessageAttributeValue.builder().dataType("String").stringValue("SandBoxDataSet").build()
        )
        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(url)
                .messageBody(JsonUtil.MAPPER.writeValueAsString(msg))
                .messageAttributes(attributes.asJava)
                .messageGroupId(msg.getJobId)
                .messageDeduplicationId(msg.getJobId)
                .build())
//        val pkp = new PharbersKafkaProducer[String, EventMsg]
//        val event = new EventMsg(msg.getJobId, traceId, "SandBoxDataSet", JsonUtil.MAPPER.writeValueAsString(msg))
//        val fu = pkp.produce(TOPIC, "", event)
//        try
//            println(fu.get(10, TimeUnit.SECONDS))
//        catch {
//            case e@(_: InterruptedException | _: ExecutionException | _: TimeoutException) =>
//                e.printStackTrace()
//        }
//        pkp.producer.close()
    }
}

object Producer {
    private val ins = new Producer
    def getIns: Producer = ins

    def withTopic(topic: String): Unit ={
        ins.TOPIC = topic
    }
}

