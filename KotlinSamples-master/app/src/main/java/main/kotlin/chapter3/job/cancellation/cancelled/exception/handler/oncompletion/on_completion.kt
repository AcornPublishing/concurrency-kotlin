package main.kotlin.chapter3.job.cancellation.cancelled.exception.handler.oncompletion

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Handle the exception of a Job using `invokeOnCompletion`
 */
fun main(args: Array<String>) = runBlocking {
    GlobalScope.launch {
        TODO("Not implemented yet!")
    }.invokeOnCompletion { cause ->
        cause?.let {
            println("Job cancelled due to ${it.message}")
        }
    }

    delay(2000)
}

