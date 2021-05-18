package main.kotlin.chapter7.actor

import android.provider.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

// This method will use an actor to print the correct value always
fun main(args: Array<String>) = runBlocking {
    val workerA = asyncIncrement(2000)
    val workerB = asyncIncrement(100)
    val workerC = asyncDecrement(1000)

    workerA.await()
    workerB.await()
    workerC.await()

    print("counter [${getCounter()}]")
}

fun asyncIncrement(by: Int) = GlobalScope.async {
    for (i in 0 until by) {
        actorCounter.send(Action.INCREASE)
    }
}

fun asyncDecrement(by: Int) = GlobalScope.async(Dispatchers.Default) {
    for (i in 0 until by) {
        actorCounter.send(Action.DECREASE)
    }
}