package main.kotlin.chapter5.producer.fibonacci

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.channels.take
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

val context = newSingleThreadContext("myThread")

/**
 * Fibonacci sequence using a producer.
 */
val fibonacci = GlobalScope.produce(context) {
    send(1L)
    var current = 1L
    var next = 1L
    while (true) {
        send(next)
        val tmpNext = current + next
        current = next
        next = tmpNext
    }
}

fun main(args: Array<String>) = runBlocking {
    fibonacci.take(10).consumeEach {
        println(it)
    }
}


