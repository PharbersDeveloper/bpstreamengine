package com.pharbers.StreamEngine.Utils.Strategy.Schema

import com.pharbers.StreamEngine.Utils.Annotation.Component
import com.pharbers.StreamEngine.Utils.Component2
import com.pharbers.StreamEngine.Utils.Strategy.BPStrategyComponent
import org.apache.kafka.common.config.ConfigDef
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.json4s._
import org.json4s.jackson.Serialization._

case class BPSchemaParseElement(key: String, `type`: String)

//object SchemaConverter extends Serializable {
@Component(name = "SchemaConverter", `type` = "SchemaConverter")
case class SchemaConverter(override val componentProperty: Component2.BPComponentConfig)
	extends Serializable with BPStrategyComponent {
	def str2SqlType(data: String): org.apache.spark.sql.types.DataType = {
		implicit val formats: DefaultFormats.type = DefaultFormats
		val lstData: List[BPSchemaParseElement] = read[List[BPSchemaParseElement]](data)
		StructType(
			lstData.map(x => StructField(x.key, x.`type` match {
				case "String" => StringType
				case "Int" => IntegerType
				case "Boolean" => BooleanType
				case "Byte" => BinaryType
				case "Double" => DoubleType
				case "Float" => FloatType
				case "Long" => LongType
				case "Fixed" => BinaryType
				case "Enum" => StringType
			}))
		)
	}

	def column2legalWithDF(colu: String, df: DataFrame): DataFrame = {
		def replaceJsonStr(json: String) = {
			implicit val formats: DefaultFormats.type = DefaultFormats
			val jsonMap = read[Map[String, String]](json)
			write(jsonMap.flatMap(x => Map(x._1.replaceAll("""[",;{}()\s\t\n]""", "") -> x._2)))
		}
		val udf_rep = udf(replaceJsonStr _)
		df.withColumn(colu, udf_rep(col(colu)))
	}

	def column2legalWithMetaDataSchema(data: Map[String, AnyRef]): Map[String, AnyRef] = {
		val schema = data("schema").asInstanceOf[List[Map[String, AnyRef]]].map { m =>
			val key = m("key").toString.replaceAll("""[",;{}()\s\t\n]""", "")
			val `type` = m("type")
			Map("key" -> key, "type" -> `type`)
		}
		Map("schema" -> schema)
	}

	override val strategyName: String = "schema convert"
	override def createConfigDef(): ConfigDef = ???
}

