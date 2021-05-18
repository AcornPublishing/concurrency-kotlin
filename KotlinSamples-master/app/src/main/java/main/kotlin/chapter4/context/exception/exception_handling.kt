package chapter4.context.exception

import kotlinx.coroutines.*

/**
 * Using CoroutineExceptionHandler to log an exception.
 */
fun main(args: Array<String>) = runBlocking {
    val handler = CoroutineExceptionHandler { context, throwable ->
        println("Error captured in $context")
        println("Message: ${throwable.message}")
    }

    GlobalScope.launch(handler) {
        TODO("Not implemented yet!")
    }

    // wait for the error to happen
    delay(500)
}