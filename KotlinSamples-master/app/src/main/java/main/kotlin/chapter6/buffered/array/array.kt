package main.kotlin.chapter6.buffered.array

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.take
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Creating an ArrayChannel
 */
fun main(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val channel = Channel<Int>(4)
        val sender = GlobalScope.launch {
            repeat(10) {
                channel.send(it)
                println("Sent $it")
            }
        }

        delay(500)

        println("Taking two")
        channel.take(2).receive()

        delay(500)
    }

    println("Took ${time}ms")
}