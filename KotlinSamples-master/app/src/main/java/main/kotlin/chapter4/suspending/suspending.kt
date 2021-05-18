package main.kotlin.chapter4.suspending

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Basic suspending function.
 */
fun main(args: Array<String>) {
    runBlocking {
        greetDelayed(1000)
    }
}

suspend fun greetDelayed(delayMillis: Int) {
    //delay(delayMillis)
    println("Hello, World!")
}