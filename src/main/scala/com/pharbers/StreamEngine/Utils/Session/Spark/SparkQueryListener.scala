package com.pharbers.StreamEngine.Utils.Session.Spark

import com.pharbers.util.log.PhLogable
import org.apache.spark.scheduler._
import org.apache.spark.sql.streaming.StreamingQueryListener

/** 功能描述
  *
  * @param args 构造参数
  * @tparam T 构造泛型参数
  * @author dcs
  * @version 0.0
  * @since 2019/11/14 10:24
  * @note 一些值得注意的地方
  */
class SparkQueryListener extends StreamingQueryListener with PhLogable{
    override def onQueryStarted(event: StreamingQueryListener.QueryStartedEvent): Unit = {
        logger.info(s"listener:${event.id},${event.name},${event.runId}")
    }

    override def onQueryProgress(event: StreamingQueryListener.QueryProgressEvent): Unit = {
        logger.info("listener:" + event.progress.prettyJson)
        logger.info("inputRowsPerSecond:" + event.progress.inputRowsPerSecond)
    }

    override def onQueryTerminated(event: StreamingQueryListener.QueryTerminatedEvent): Unit = {
        logger.info(s"listener:${event.id},${event.exception.getOrElse("null")},${event.runId}")
        event.exception match {
            case Some(e) => logger.error(s"listener:${event.id},$e,${event.runId}")
            case _ => logger.info(s"listener:${event.id},${event.runId}")
        }
    }
}

class BPSparkListener extends SparkListener with PhLogable{
    override def onJobStart(jobStart: SparkListenerJobStart): Unit = {
        logger.debug("job start" + jobStart.jobId)
    }
    override def onTaskStart(taskStart: SparkListenerTaskStart): Unit = {
        logger.debug("task start" + taskStart.stageId)
    }

    override def onTaskEnd(taskEnd: SparkListenerTaskEnd): Unit = {
        logger.debug("onTaskEnd" + taskEnd.stageId)
    }

    override def onOtherEvent(event: SparkListenerEvent): Unit = {
        logger.debug("other event" + event.toString)
    }

    override def onExecutorAdded(executorAdded: SparkListenerExecutorAdded): Unit ={
        logger.debug("onExecutorAdded" + executorAdded.executorId + executorAdded.executorInfo)
    }

}
