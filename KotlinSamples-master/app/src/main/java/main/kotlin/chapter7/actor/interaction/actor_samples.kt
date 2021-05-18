package main.kotlin.chapter7.actor.interaction

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

/**
 * Interacting with an actor.
 */
fun main(args: Array<String>) = runBlocking {
    bufferedActor()
    actorWithContext()
    lazyActor()
}

suspend fun bufferedActor() {
    val bufferedPrinter = GlobalScope.actor<String>(capacity = 10) {
       for (msg in channel) {
           println(msg)
       }
    }

    bufferedPrinter.send("hello")
    bufferedPrinter.send("world")

    bufferedPrinter.close()
}

suspend fun actorWithContext() {
    val dispatcher = newFixedThreadPoolContext(3, "pool")
    val actor = GlobalScope.actor<String>(dispatcher) {
        for (msg in channel) {
            println("Running in ${Thread.currentThread().name}")
        }
    }

    for (i in 1..10) {
        actor.send("a")
    }
}

suspend fun lazyActor() {
    val actor = GlobalScope.actor<String>(start = CoroutineStart.LAZY) {
        for (msg in channel) {
            println(msg)
        }
    }

    actor.send("hello lazy")
}