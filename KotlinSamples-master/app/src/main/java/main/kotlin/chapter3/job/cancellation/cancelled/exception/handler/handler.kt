package main.kotlin.chapter3.job.cancellation.cancelled.exception.handler

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * Handle the exception in a Job using
 * a CoroutineExceptionHandler
 */
fun main(args: Array<String>) = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler {
        _: CoroutineContext, throwable: Throwable ->
        println("Job cancelled due to ${throwable.message}")
    }

    GlobalScope.launch(exceptionHandler) {
        TODO("Not implemented yet!")
    }

    delay(2000)
}