package main.kotlin.chapter3.job

import kotlinx.coroutines.*

/**
 * This code instantiates a Job by using launch
 * and another by using the factory function. Notice
 * that in both cases they will be started automatically
 */
fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch {
        TODO("Not implemented yet!")
    }

    val job2 = Job()

    delay(500)
}