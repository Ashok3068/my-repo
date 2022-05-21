import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket
import java.util.*

fun client2() {
    val client = Socket("127.0.0.1", 9999)
    val output = PrintWriter(client.getOutputStream(), true)
    val input = BufferedReader(InputStreamReader(client.inputStream))
    var sc:Scanner?=null;
            while (true){


                sc=  Scanner(System.`in`);


    println("Client sending [Hello]")
    output.println(sc.next())

    println("Client receiving [${input.lines().toArray()}]")
    }

}
fun main() {

    client2()
}