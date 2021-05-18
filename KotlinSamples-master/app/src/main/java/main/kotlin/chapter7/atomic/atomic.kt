package main.kotlin.chapter7.atomic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicInteger

// This method will print the correct value `2100`
// because it's calculated using an AtomicInteger.
fun main(args: Array<String>) = runBlocking {
    val workerA = asyncIncrement(2000)
    val workerB = asyncIncrement(100)

    workerA.await()
    workerB.await()

    print("counter [$counter]")
}

var counter = AtomicInteger()

fun asyncIncrement(by: Int) = GlobalScope.async {
    for (i in 0 until by) {
        counter.incrementAndGet()
    }
}