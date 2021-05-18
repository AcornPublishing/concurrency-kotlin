package main.kotlin.chapter4.context.mix.separate

import kotlinx.coroutines.*

/**
 * Use `minusKey()` to separate two contexts previously joined.
 */
fun main(args: Array<String>) = runBlocking {
    val dispatcher = newSingleThreadContext("myDispatcher")
    val handler = CoroutineExceptionHandler { _, throwable ->
        println("Error captured")
        println("Message: ${throwable.message}")
    }

    // Combine two contexts together
    val context = dispatcher + handler

    // Remove one element from the context
    val tmpCtx = context.minusKey(dispatcher.key)

    GlobalScope.launch(tmpCtx) {
        println("Running in ${Thread.currentThread().name}")
        TODO("Not implemented!")
    }.join()
}