//package com.pharbers.StreamEngine.Jobs.OssJob.OssJobContainer
//
//import java.util.UUID
//
//import com.pharbers.StreamEngine.Jobs.OssPartitionJob.BPSOssPartitionJob
//import com.pharbers.StreamEngine.Utils.Job.{BPDynamicStreamJob, BPSJobContainer, BPStreamJob}
//import com.pharbers.StreamEngine.Jobs.OssJob.OssListenerV2.BPSOssListenerV2
//import com.pharbers.StreamEngine.Utils.Component2
//import com.pharbers.StreamEngine.Utils.Event.EventHandler.BPSEventHandler
//import com.pharbers.StreamEngine.Utils.Event.StreamListener.BPStreamListener
//import com.pharbers.StreamEngine.Utils.Strategy.BPSKfkBaseStrategy
//import org.apache.kafka.common.config.ConfigDef
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql.functions._
//
//object BPSOssJobContainer {
//    def apply(strategy: BPSKfkBaseStrategy, spark: SparkSession): BPSOssJobContainer = new BPSOssJobContainer(strategy, spark, Map.empty)
//
//    def apply(strategy: BPSKfkBaseStrategy, spark: SparkSession, config: Map[String, String]): BPSOssJobContainer = new BPSOssJobContainer(strategy, spark, config)
//}
//
//class BPSOssJobContainer(override val strategy: BPSKfkBaseStrategy, val spark: SparkSession, config: Map[String, String]) extends BPSJobContainer{
//    val id = UUID.randomUUID().toString
//    type T = BPSKfkBaseStrategy
//    import spark.implicits._
//    //    val listener = new BPSOssListener(spark, this)
//
//    override def open(): Unit = {
//        //todo: options(map[String, String])
//        val reading = spark.readStream
//            .format("kafka")
//            .option("kafka.bootstrap.servers", "123.56.179.133:9092")
//            .option("kafka.security.protocol", "SSL")
//            .option("kafka.ssl.keystore.location", "./kafka.broker1.keystore.jks")
//            .option("kafka.ssl.keystore.password", "pharbers")
//            .option("kafka.ssl.truststore.location", "./kafka.broker1.truststore.jks")
//            .option("kafka.ssl.truststore.password", "pharbers")
//            .option("kafka.ssl.endpoint.identification.algorithm", " ")
//            .option("subscribe", strategy.getTopic)
//            .option("startingOffsets", "earliest")
//            .load()
//
//        inputStream = Some(reading
//            .selectExpr(
//                """deserialize(value) AS value""",
//                "timestamp"
//            ).toDF()
//            .withWatermark("timestamp", "24 hours")
//            .select(
//                from_json($"value", strategy.getSchema).as("data"), col("timestamp")
//            ).select("data.*", "timestamp"))
//    }
//
//    override def exec(): Unit = inputStream match {
//        case Some(is) => {
//            val listener = new BPSOssListenerV2(spark, this)
//            listener.active(is)
//            listeners = listener :: listeners
//        }
//        case None => ???
//    }
//
//    override def getJobWithId(id: String, category: String = ""): BPStreamJob = {
//        jobs.get(id) match {
//            case Some(job) => job
//            case None => {
////                val job = BPSOssPartitionJob(id, spark, this.inputStream, this)
////                job.exec()
////                jobs += id -> job
////                job
//            }
//        }
//    }
//
//    override val componentProperty: Component2.BPComponentConfig = null
//
//    override def createConfigDef(): ConfigDef = ???
//
//    override val description: String = "oss_job"
//}
