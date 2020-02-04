package com.pharbers.StreamEngine.Utils.StreamJob.JobStrategy

import java.util.UUID

import com.pharbers.StreamEngine.Utils.Config.BPSConfig
import org.apache.kafka.common.config.ConfigDef
import org.apache.kafka.common.config.ConfigDef.{Importance, Type}
import org.apache.spark.sql.types.DataType

/** 功能描述
 *
 * @author dcs
 * @version 0.0
 * @since 2020/02/04 14:02
 * @note 一些值得注意的地方
 */
case class BPSCommonJoBStrategy(config: Map[String, String], inoutConfigDef: ConfigDef = new ConfigDef()) extends BPSJobStrategy with BPSJobIdConfigStrategy {
    val JOB_ID_CONFIG_KEY = "jobId"
    val JOB_ID_CONFIG_DOC = "job id"
    val RUN_ID_CONFIG_KEY = "runId"
    val RUN_ID_CONFIG_DOC = "run id"
    val configDef = inoutConfigDef
            .define(JOB_ID_CONFIG_KEY, Type.STRING, UUID.randomUUID().toString, Importance.HIGH, JOB_ID_CONFIG_DOC)
            .define(RUN_ID_CONFIG_KEY, Type.STRING, UUID.randomUUID().toString, Importance.HIGH, RUN_ID_CONFIG_DOC)
    val jobConfig = BPSConfig(configDef, config)

    override def getTopic: String = ""

    override def getSchema: DataType = null

    override def getJobConfig: BPSConfig = jobConfig

    override def getRunId: String = jobConfig.getString(RUN_ID_CONFIG_KEY)

    override def getJobId: String = jobConfig.getString(JOB_ID_CONFIG_KEY)
}