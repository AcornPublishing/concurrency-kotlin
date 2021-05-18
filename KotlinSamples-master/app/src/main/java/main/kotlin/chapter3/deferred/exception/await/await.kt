package main.kotlin.chapter3.deferred.exception.await

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * In this example the exception will be propagated because we
 * are calling await()
 */
fun main(args: Array<String>) = runBlocking<Unit> {
    val deferred = GlobalScope.async {
        TODO("Not implemented yet!")
    }

    // Let it fail
    deferred.await()
}