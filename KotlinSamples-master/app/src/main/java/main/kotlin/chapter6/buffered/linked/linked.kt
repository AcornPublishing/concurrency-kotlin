package main.kotlin.chapter6.buffered.linked

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Creating a LinkedListChannel
 */
fun main(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val channel = Channel<Int>(Channel.UNLIMITED)
        val sender = GlobalScope.launch {
            repeat(5) {
                println("Sending $it")
                channel.send(it)
            }
        }

        delay(500)
    }

    println("Took ${time}ms")
}