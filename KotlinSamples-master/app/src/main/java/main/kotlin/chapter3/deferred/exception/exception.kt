package main.kotlin.chapter3.deferred.exception

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * In this example the exception will not be propagated
 * because `await()` isn't being called
 */
fun main(args: Array<String>) = runBlocking {
    val deferred = GlobalScope.async {
        TODO("Not implemented yet!")
    }

    // Wait for it to fail
    delay(2000)
}