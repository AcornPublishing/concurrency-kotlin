package main.kotlin.chapter3.job.cancellation

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * This code cancels a Job without a cause
 */
fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch {
        // Do some work here
        delay(5000)
    }

    // timeout for the operation
    delay(2000)
    job.cancel()
}