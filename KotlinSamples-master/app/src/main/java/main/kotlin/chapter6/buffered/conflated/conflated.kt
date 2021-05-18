package main.kotlin.chapter6.buffered.conflated

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
//import kotlinx.coroutines.channels.ConflatedChannel
import kotlinx.coroutines.channels.take
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Creating a Conflated channel.
 */
fun main(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val channel = Channel<Int>(Channel.CONFLATED)
        GlobalScope.launch {
            repeat(5) {
                channel.send(it)
                println("Sent $it")
            }
        }
        delay(500)
        val element = channel.receive()
        println("Received $element")
    }

    println("Took ${time}ms")
}