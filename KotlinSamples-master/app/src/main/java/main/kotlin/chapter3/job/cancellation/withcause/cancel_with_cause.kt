package main.kotlin.chapter3.job.cancellation.withcause

import kotlinx.coroutines.*
import java.lang.Exception

/**
 * This passes a cause when cancelling a Job
 */
@InternalCoroutinesApi
fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch {
        // Do some work here
        delay(5000)
    }

    delay(2000)

    // cancel with a cause
    job.cancel(cause = CancellationException("Tired of waiting"))

    val cancellation = job.getCancellationException()
    print(cancellation.message)
}