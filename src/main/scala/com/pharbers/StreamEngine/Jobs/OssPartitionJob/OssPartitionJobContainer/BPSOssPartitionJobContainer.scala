package com.pharbers.StreamEngine.Jobs.OssPartitionJob.OssJobContainer

import java.util.UUID

import com.pharbers.StreamEngine.Jobs.OssPartitionJob.BPSOssPartitionJob
import com.pharbers.StreamEngine.Utils.StreamJob.{BPSJobContainer, BPStreamJob}
import com.pharbers.StreamEngine.Jobs.OssPartitionJob.OssListener.BPSOssListener
import com.pharbers.StreamEngine.Utils.StreamJob.JobStrategy.BPSKfkJobStrategy
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object BPSOssPartitionJobContainer {
    def apply(strategy: BPSKfkJobStrategy, spark: SparkSession): BPSOssPartitionJobContainer = new BPSOssPartitionJobContainer(strategy, spark)
}

class BPSOssPartitionJobContainer(override val strategy: BPSKfkJobStrategy, val spark: SparkSession) extends BPSJobContainer {
    val id = UUID.randomUUID().toString
    type T = BPSKfkJobStrategy
    import spark.implicits._
    //    val listener = new BPSOssListener(spark, this)

    override def open(): Unit = {
        val reading = spark.readStream
            .format("kafka")
            .option("kafka.bootstrap.servers", "123.56.179.133:9092")
            .option("kafka.security.protocol", "SSL")
            .option("kafka.ssl.keystore.location", "./kafka.broker1.keystore.jks")
            .option("kafka.ssl.keystore.password", "pharbers")
            .option("kafka.ssl.truststore.location", "./kafka.broker1.truststore.jks")
            .option("kafka.ssl.truststore.password", "pharbers")
            .option("kafka.ssl.endpoint.identification.algorithm", " ")
            .option("subscribe", strategy.getTopic)
            .option("startingOffsets", "earliest")
            .load()

        inputStream = Some(reading
            .selectExpr(
                """deserialize(value) AS value""",
                "timestamp"
            ).toDF()
            .withWatermark("timestamp", "24 hours")
            .select(
                from_json($"value", strategy.getSchema).as("data"), col("timestamp")
            ).select("data.*", "timestamp"))
    }

    override def exec(): Unit = inputStream match {
        case Some(is) => {
            val listener = new BPSOssListener(spark, this)
            listener.active(is)
            listeners = listener :: listeners

            is.filter($"type" === "SandBox").writeStream
                .partitionBy("jobId")
                .format("csv")
                .outputMode("append")
                .option("checkpointLocation", "/test/streamingV2/" + this.id + "/checkpoint")
                .option("path", "/test/streamingV2/" + this.id + "/files")
                .start()
        }
        case None => ???
    }

    override def getJobWithId(id: String, category: String = ""): BPStreamJob = {
        jobs.get(id) match {
            case Some(job) => job
            case None => {
                val job = BPSOssPartitionJob(id, spark, this.inputStream, this)
                job.exec()
                jobs += id -> job
                job
            }
        }
    }
}