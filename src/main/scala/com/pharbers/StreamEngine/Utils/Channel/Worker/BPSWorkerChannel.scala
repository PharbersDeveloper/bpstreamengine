package com.pharbers.StreamEngine.Utils.Channel.Worker

import java.net.{InetAddress, InetSocketAddress}
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel

import com.pharbers.StreamEngine.Utils.Log.PhLogable

object BPSWorkerChannel {
    //    var host: Broadcast[String] = _
    val port: Int = 56789

    def apply(host: String): BPSWorkerChannel = {
        val tmp = new BPSWorkerChannel(host, port)
        tmp.connect()
        tmp
    }

    //    def init(hostBroadcast: Broadcast[String]): Unit ={
    //        host = hostBroadcast
    //    }
}

// TODO 希望可以补全注释
// TODO: 这是一个问题，外部创建，后期在做调整
class BPSWorkerChannel(host: String, port: Int) extends Serializable with PhLogable {

    lazy val addr = new InetSocketAddress(host, port)

    var client: Option[SocketChannel] = None

    def connect(): Unit = {
        try {
            client = Some(SocketChannel.open(addr))
        } catch {
            case e: Exception =>
                logger.error(e.getMessage, e)
                throw e
        }
        logger.info("Connecting to Server on port 55555 ...")
    }

    def pushMessage(msg: String): Unit = {
        val message = msg.getBytes()
        val msgLength = message.length
        val b = Array[Byte](
            (msgLength >> 24 & 0xff).toByte,
            (msgLength >> 16 & 0xff).toByte,
            (msgLength >> 8 & 0xff).toByte,
            (msgLength & 0xff).toByte
        )
        b(3) = (msgLength & 0xff).toByte
        b(2) = (msgLength >> 8 & 0xff).toByte
        b(1) = (msgLength >> 16 & 0xff).toByte
        b(0) = (msgLength >> 24 & 0xff).toByte
        val lengthBuffer = ByteBuffer.wrap(b)
        val buffer = ByteBuffer.wrap(message)
        client match {
            case Some(c) =>
                c.write(lengthBuffer)
                while (buffer.hasRemaining) {
                    c.write(buffer)
                }
            case None =>
                logger.error("client未成功连接")
        }

        buffer.clear()
//        Thread.sleep(1000)
    }

    def close(): Unit = client.get.close()
}
