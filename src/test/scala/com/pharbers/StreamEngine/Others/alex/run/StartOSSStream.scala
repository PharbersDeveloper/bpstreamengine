package com.pharbers.StreamEngine.Others.alex.run

import java.net.InetAddress
import java.util.Collections

import com.pharbers.StreamEngine.Utils.Channel.Worker.BPSWorkerChannel
import com.pharbers.StreamEngine.Utils.Component2.BPSConcertEntry
import com.pharbers.StreamEngine.Utils.Event.BPSEvents
import com.pharbers.StreamEngine.Utils.Job.Status.BPSJobStatus
import com.pharbers.StreamEngine.Utils.Module.bloodModules.{AssetDataMartModel, BloodModel, BloodModel2, ComplementAssetModel, UploadEndModel}
import com.pharbers.StreamEngine.Utils.Strategy.Blood.BPSSetBloodStrategy
import com.pharbers.StreamEngine.Utils.Strategy.Session.Kafka.BPKafkaSession
import org.bson.types.ObjectId
import org.scalatest.FunSuite
import org.json4s.DefaultFormats
import org.json4s.jackson.Serialization._

class StartOSSStream extends FunSuite {
	implicit val formats: DefaultFormats.type = DefaultFormats
	val events: BPSEvents = BPSEvents("", "", "SandBox-Start", Map())
	test("start dcs local job") {
		val workerChannel = BPSWorkerChannel(InetAddress.getLocalHost.getHostAddress)
		workerChannel.pushMessage(write(events))
	}
	
	test("start dcs online job") {
		def getKafka: BPKafkaSession = BPSConcertEntry.queryComponentWithId("kafka").get.asInstanceOf[BPKafkaSession]
		getKafka.callKafka(events)
	}
	
	test("模拟Connector发送 确认开始") {
		val bloodStrategy: BPSSetBloodStrategy = new BPSSetBloodStrategy(Map.empty)
		val mongoId = "5ebfd5789bb9aa05a2c60eec"//new ObjectId().toString
		val dataSet = BloodModel(
			mongoId,
			"5eb386d93c5d7a00970f9541",
			jobId = "5ec3a659ab9230110aa6254f",
			status = BPSJobStatus.Start.toString)
		bloodStrategy.pushBloodInfo(dataSet, "0001", "00001", "SandBoxDataSet_2")
	}
	
	test("模拟发送blood 信息到golang") {
		val bloodStrategy: BPSSetBloodStrategy = new BPSSetBloodStrategy(Map.empty)
		val cloNames = List[String]("a", "b", "c")
		val totalNum: Long = 10000
		val mongoId = "5ebfd5789bb9aa05a2c60eec"//new ObjectId().toString
		val dataSet = BloodModel(
			mongoId,
			"5eb386d93c5d7a00970f9541",
			Nil,
			"002132100321",
			cloNames,
			"Fuck",
			totalNum,
			"/jobs/name/qp",
			"SampleData", BPSJobStatus.End.toString)
		
		bloodStrategy.pushBloodInfo(dataSet, "0001", "00001", "SandBoxDataSet-Test")
	}
	
	test("模拟发送upload end 信息到golang") {
		val bloodStrategy: BPSSetBloodStrategy = new BPSSetBloodStrategy(Map.empty)
		val uploadEnd = UploadEndModel(new ObjectId().toString, "5dd5223f83de972f084b000e")
		
		bloodStrategy.uploadEndPoint(uploadEnd, "0001", "00001")
	}
	
	test("模拟发送data mart 信息到golang") {
		val bloodStrategy: BPSSetBloodStrategy = new BPSSetBloodStrategy(Map.empty)
		val dataMartValue = new AssetDataMartModel(
			"assetName",
			"",
			"0.0.18",
			"mart",
			"*" :: Nil,
			"*" :: Nil,
			"*" :: Nil,
			"*" :: Nil,
			"*" :: Nil,
			"*" :: Nil,
			new ObjectId().toString :: Nil,
			"tableName",
			s"/common/public/",
			"hive",
			"append"
		)
		
		bloodStrategy.pushBloodInfo(dataMartValue, "0001", "00001", "AssetDataMart-Test")
	}
	
	test("模拟发送 complement asset 信息到golang") {
		val bloodStrategy: BPSSetBloodStrategy = new BPSSetBloodStrategy(Map.empty)
		val complementAsset = ComplementAssetModel(List("CHC", "BMS"),List("高血压"),List("AAA", "BBB"),List("2020-01", "2020-02"),List("北京", "上海"))
		
		bloodStrategy.complementAsset(complementAsset, "0001", "0001")
	}

	test("模拟发送邓钱 Job结束") {
		val bloodStrategy: BPSSetBloodStrategy = new BPSSetBloodStrategy(Map.empty)
		val bloodModel = BloodModel2(
			jobId = "schema_job_5ec6093b404c0531bff29ac9",
			columnNames = "A" :: "B" :: Nil,
			tabName = "Fuck",
			length = 100,
			url = "s3a://ph-stream/jobs/runId_xxxx/schemaJob/jobId_xxxx/subId_xxxx/xxxxxx",
			description = "schemaJob",
			status = BPSJobStatus.End.toString)
		bloodStrategy.pushBloodInfo(bloodModel, "0001", "00001", "PushDs")
	}
	
}
