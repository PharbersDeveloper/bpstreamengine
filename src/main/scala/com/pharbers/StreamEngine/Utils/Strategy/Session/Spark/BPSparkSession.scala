package com.pharbers.StreamEngine.Utils.Strategy.Session.Spark

import java.net.InetAddress
import java.util.Properties
import java.io.FileInputStream

import collection.JavaConverters._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import com.pharbers.StreamEngine.Utils.Config.BPSConfig
import com.pharbers.StreamEngine.Utils.Annotation.Component
import com.pharbers.StreamEngine.Utils.Component2.BPComponentConfig

object BPSparkSession {
    def apply(config: BPComponentConfig): BPSparkSession = new BPSparkSession(config)

    implicit def typeConvertor(in: BPSparkSession): SparkSession = in.spark
}

/** 创建 SparkSession 实例
 *
 * @author clock
 * @version 0.0.1
 * @since 2019/11/6 17:37
 * @node 可用的配置参数
 * {{{
 *     spark.configs.path = spark 配置文件目录
 *     app.name = 项目名称
 *     master = master节点
 *     log.level = 日志等级
 * }}}
 * @example {{{val spark = new BPSparkSession(Map("log.level" -> "INFO"))}}}
 */
@Component(name = "BPSparkSession", `type` = "session")
class BPSparkSession(override val componentProperty: BPComponentConfig) extends BPSparkSessionConfig {
    // 此处 Config 的配置优先级高于 Submit 时设置的配置
    private val sparkConfigs =
        if (componentProperty != null) BPSConfig(configDef, componentProperty.config.asJava)
        else BPSConfig(configDef, Map.empty[String, String])
    private val pops = new Properties()
    pops.load(new FileInputStream(sparkConfigs.getString(SPARK_CONFIGS_PATH_KEY)))

    private val conf = new SparkConf()
            .setAll(pops.asScala)
            .setAppName(sparkConfigs.getString(APP_NAME_KEY))
            .setMaster(sparkConfigs.getString(MASTER_KEY))

    val spark: SparkSession = SparkSession.builder().config(conf)
            .enableHiveSupport()
            .getOrCreate()
    spark.sparkContext.setLogLevel(sparkConfigs.getString(LOG_LEVEL_KEY))
    spark.sparkContext.setLocalProperty("host", InetAddress.getLocalHost.getHostAddress)
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", sys.env("AWS_ACCESS_KEY_ID"))
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", sys.env("AWS_SECRET_ACCESS_KEY"))
    spark.sparkContext.hadoopConfiguration.set("fs.s3a.endpoint", "s3.cn-northwest-1.amazonaws.com.cn")
    logger.info("添加SparkQueryListener")
    spark.streams.addListener(new SparkQueryListener)
    // 初始环境设置
    sparkConfigs.getString(RUN_MODEL_KEY) match {
        case "client" =>
            spark.sparkContext.addJar("./target/BP-Stream-Engine-1.0-SNAPSHOT.jar")

            spark.sparkContext.addJar("./jars/common-config-5.2.1.jar")
            spark.sparkContext.addJar("./jars/common-utils-5.2.1.jar")
            spark.sparkContext.addJar("./jars/elasticsearch-spark-20_2.11-7.2.0.jar")
            spark.sparkContext.addJar("./jars/kafka-avro-serializer-5.2.1.jar")
            spark.sparkContext.addJar("./jars/kafka-clients-2.0.0.jar")
            spark.sparkContext.addJar("./jars/kafka-schema-registry-client-5.2.1.jar")
            spark.sparkContext.addJar("./jars/log4j-api-2.11.2.jar")
            spark.sparkContext.addJar("./jars/log4j-core-2.11.2.jar")
            spark.sparkContext.addJar("./jars/logs-1.0.jar")
            spark.sparkContext.addJar("./jars/spark-sql-kafka-0-10_2.11-2.3.0.jar")
        case _ =>
    }
    override val sessionType: String = "spark"
}
