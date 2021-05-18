package main.kotlin.chapter3.job.cancellation.cancelled

import kotlinx.coroutines.*

@InternalCoroutinesApi
fun main(args: Array<String>) = runBlocking<Unit> {
    val job = GlobalScope.launch {
        delay(5000)
    }

    delay(2000)

    // cancel
    //job.cancel(cause = Exception("Tired of waiting"))

    val cancellation = job.getCancellationException()
    cancellation.cause // Exception("Tired of waiting")
}