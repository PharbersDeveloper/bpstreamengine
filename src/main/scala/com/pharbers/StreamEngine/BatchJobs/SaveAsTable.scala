package com.pharbers.StreamEngine.BatchJobs

import org.apache.spark.sql.SparkSession

/** 为Python提供的 api, 保存一个 DataFrame 到 Hive
 *
 * @author clock
 * @version 0.1
 * @since 2020/09/04 15:32
 * @note
 * {{{
$SPARK_HOME/bin/spark-submit \
--name saveAsTable-submit \
--master yarn \
--deploy-mode cluster \
--driver-memory 1g \
--executor-memory 1g \
--executor-cores 1 \
--num-executors 1 \
--conf spark.hadoop.fs.s3a.access.key=AKIAWPBDTVEAJ6CCFVCP \
--conf spark.hadoop.fs.s3a.secret.key=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 \
--conf spark.hadoop.fs.s3a.endpoint=s3.cn-northwest-1.amazonaws.com.cn \
--class com.pharbers.StreamEngine.BatchJobs.SaveAsTable \
s3a://ph-platform/2020-08-10/functions/scala/BPStream/SaveAsTable-20200904.jar \
parquet s3a://ph-stream/common/public/prod/16 \
parquet s3a://ph-stream/common/public/prod/17 \
overwrite prod20
 * }}}
 */
object SaveAsTable {
    def main(args: Array[String]): Unit = {
        val input_file_format = args(0).toString
        val input_path = args(1).toString
        val output_file_format = args(2).toString
        val output_path = args(3).toString
        val save_mode = args(4).toString
        val table_name = args(5).toString

        val spark: SparkSession = SparkSession.builder().enableHiveSupport().getOrCreate()
        val input_df = input_file_format match {
            case "json" => spark.read.json(input_path)
            case _ => spark.read.parquet(input_path)
        }
        input_df.coalesce(4).write
                .mode(save_mode)
                .format(output_file_format)
                .option("path", output_path)
                .saveAsTable(table_name)
    }
}

