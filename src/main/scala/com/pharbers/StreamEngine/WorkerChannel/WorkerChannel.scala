package com.pharbers.StreamEngine.WorkerChannel

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel

object WorkerChannel {
    def apply(): WorkerChannel = {
        val tmp = new WorkerChannel()
        println(tmp.host)
        println(tmp.port)
        println(tmp.addr)
        tmp.connect()
        tmp
    }
}

class WorkerChannel extends Serializable {

    lazy val host: String = "192.168.100.115"
    lazy val port: Int = 56789

    lazy val addr = new InetSocketAddress(host, port)
    var client: Option[SocketChannel] = None

    def connect(): Unit = {
        client = Some(SocketChannel.open(addr))
        println("Connecting to Server on port 55555 ...")
    }

    def pushMessage(msg: String): Unit = {
        val message = msg.getBytes()
        val buffer = ByteBuffer.wrap(message)
        client match {
            case Some(c) => c.write(buffer)
            case None => ???
        }

        println("sending: " + msg)
        buffer.clear()
    }

    def close(): Unit = client.get.close()
}
