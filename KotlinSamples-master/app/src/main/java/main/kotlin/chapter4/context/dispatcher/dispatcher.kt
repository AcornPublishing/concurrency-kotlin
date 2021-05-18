package main.kotlin.chapter4.context.dispatcher

import kotlinx.coroutines.*

/**
 * This file contains examples of different types of dispatchers
 */
fun main(args: Array<String>) {
    commonPool()
    defaultDispatcher()
    unconfined()
    singleThread()
    threadPool()
}

fun commonPool() = runBlocking {
    GlobalScope.launch(Dispatchers.Default) {
        println("Running in ${Thread.currentThread().name}")
    }.join()
}

fun defaultDispatcher() = runBlocking {
    GlobalScope.launch {
        println("Running in ${Thread.currentThread().name}")
    }.join()

    GlobalScope.launch(Dispatchers.Default) {
        println("Running in ${Thread.currentThread().name}")
    }.join()
}

fun unconfined() = runBlocking {
    GlobalScope.launch(Dispatchers.Unconfined) {
        println("Starting in ${Thread.currentThread().name}")
        delay(500)
        println("Resuming in ${Thread.currentThread().name}")
    }.join()
}

fun singleThread() = runBlocking {
    val dispatcher = newSingleThreadContext("myThread")

    GlobalScope.launch(dispatcher) {
        println("Starting in ${Thread.currentThread().name}")
        delay(500)
        println("Resuming in ${Thread.currentThread().name}")
    }.join()
}

fun threadPool() = runBlocking {
    val dispatcher = newFixedThreadPoolContext(4, "myPool")

    GlobalScope.launch(dispatcher) {
        println("Starting in ${Thread.currentThread().name}")
        delay(500)
        println("Resuming in ${Thread.currentThread().name}")
    }.join()
}