package main.kotlin.chapter2.dispatcher

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

// Use a ThreadPoolDispatcher to run the coroutine
fun main(args: Array<String>) = runBlocking {
    val netDispatcher = newSingleThreadContext(name = "ServiceCall")

    val task = GlobalScope.launch(netDispatcher) {
        printCurrentThread()
    }

    task.join()
}

fun printCurrentThread() {
    println("Running in thread [${Thread.currentThread().name}]")
}

