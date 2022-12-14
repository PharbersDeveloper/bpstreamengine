package com.pharbers.StreamEngine.Jobs.SqlTableJob.SqlTableListener

import com.pharbers.StreamEngine.Utils.Config.BPSConfig
import com.pharbers.StreamEngine.Utils.Strategy.hdfs.BPSHDFSFile
import org.apache.kafka.common.config.ConfigDef
import org.apache.kafka.common.config.ConfigDef.{Importance, Type}
import org.apache.spark.sql.{DataFrame, SparkSession}
import com.pharbers.StreamEngine.Utils.Component2
import com.pharbers.StreamEngine.Utils.Component2.BPSConcertEntry
import com.pharbers.StreamEngine.Utils.Job.{BPSJobContainer, BPStreamJob}
import com.pharbers.StreamEngine.Utils.Strategy.Schema.BPSParseSchema
import com.pharbers.StreamEngine.Jobs.SqlTableJob.SqlTableListener.BPStreamOverCheckJob._
import com.pharbers.StreamEngine.Utils.Event.BPSEvents
import com.pharbers.StreamEngine.Utils.Strategy.JobStrategy.BPSCommonJobStrategy
import com.pharbers.StreamEngine.Utils.Strategy.s3a.BPS3aFile

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/12/11 14:45
  * @note 一些值得注意的地方
  */
class BPStreamOverCheckJob(container: BPSJobContainer, override val componentProperty: Component2.BPComponentConfig) extends BPStreamJob {

    override type T = BPSCommonJobStrategy
    override val strategy: BPSCommonJobStrategy = BPSCommonJobStrategy(componentProperty, configDef)
    override val id: String = strategy.getId
    override val description: String = "checkStream"
    override val spark: SparkSession = strategy.getSpark

    def createConfigDef(): ConfigDef = new ConfigDef()
            .define(LENGTH_CONFIG_KEY, Type.LONG, 0L, Importance.HIGH, LENGTH_CONFIG_DOC)
            .define(ROW_RECORD_PATH_CONFIG_KEY, Type.STRING, "", Importance.HIGH, ROW_RECORD_PATH_CONFIG_DOC)
            .define(METADATA_PATH_CONFIG_KEY, Type.STRING, "", Importance.HIGH, METADATA_PATH_CONFIG_DOC)
            .define(PUSH_KEY, Type.STRING, Importance.HIGH, PUSH_DOC)

    lazy val hdfsfile: BPS3aFile = strategy.getS3aFile
    val jobConfig: BPSConfig = strategy.jobConfig

    override def exec(): Unit = {
            checkLength()
    }

    def checkLength(): Unit ={
        val rows = hdfsfile.readFiles(jobConfig.getString(ROW_RECORD_PATH_CONFIG_KEY)).map(_.toLong).sum
        logger.debug(s"row record path: ${jobConfig.getString(ROW_RECORD_PATH_CONFIG_KEY)}")
        logger.debug(s"rows: $rows")
        logger.debug(s"length: ${jobConfig.getLong(LENGTH_CONFIG_KEY)}")
        if (rows >= jobConfig.getLong(LENGTH_CONFIG_KEY)) {
            logger.info(s"启动sql job")
            val metadataPath: String = jobConfig.getString(METADATA_PATH_CONFIG_KEY)
            val ps = BPSConcertEntry.queryComponentWithId("parse schema").get.asInstanceOf[BPSParseSchema]
            val metadata = ps.parseMetadata(metadataPath)(spark)
            val providers = metadata.getOrElse("providers", List("")).asInstanceOf[List[String]]
            strategy.pushMsg(BPSEvents(strategy.getJobId, strategy.getTraceId, jobConfig.getString(PUSH_KEY), providers), isLocal = true)
        } else {
            //test用
            logger.error(s"row record path: ${jobConfig.getString(ROW_RECORD_PATH_CONFIG_KEY)}")
            logger.error(s"rows: $rows")
            logger.error(s"length: ${jobConfig.getLong(LENGTH_CONFIG_KEY)}")
            strategy.pushMsg(BPSEvents(strategy.getJobId, strategy.getTraceId, jobConfig.getString(PUSH_KEY), ""), isLocal = true)
        }
    }

}

object BPStreamOverCheckJob {
    lazy final val LENGTH_CONFIG_KEY = "length"
    lazy final val LENGTH_CONFIG_DOC = "end length"
    lazy final val ROW_RECORD_PATH_CONFIG_KEY = "rowRecordPath"
    lazy final val ROW_RECORD_PATH_CONFIG_DOC = "already read row record path"
    lazy final val METADATA_PATH_CONFIG_KEY = "metadataPath"
    lazy final val METADATA_PATH_CONFIG_DOC = "metadataPath"
    lazy final val PUSH_KEY = "pushType"
    lazy final val PUSH_DOC = "push event type"

}
