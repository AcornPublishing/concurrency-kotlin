package main.kotlin.chapter5.iterator.fibonacci

import kotlinx.coroutines.runBlocking
import kotlin.sequences.iterator

/**
 * Implementation of a Fibonacci sequence using
 * an iterator.
 */
fun main(args: Array<String>) = runBlocking {
    val fibonacci = iterator {
        yield(1L)
        var current = 1L
        var next = 1L
        while (true) {
            yield(next)
            val tmpNext = current + next
            current = next
            next = tmpNext
        }
    }

    for (i in 0..91) {
        println("$i is ${fibonacci.next()}")
    }
}

