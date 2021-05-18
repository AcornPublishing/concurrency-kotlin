package main.kotlin.chapter3.deferred

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * Examples of how to instantiate a Deferred
 */
fun main(args: Array<String>) = runBlocking {
    // Create a Deferred using `async`
    val headlines = GlobalScope.async {
        getHeadlines()
    }

    // Wait for it to complete
    headlines.await()

    // Create a Deferred using the factory function
    val deferred = CompletableDeferred<Unit>()
}

fun getHeadlines() {
    // Nothing to do here
}

// Dummy class
class Article

// A deferred can be created using the constructor as well
val articles = CompletableDeferred<List<Article>>()