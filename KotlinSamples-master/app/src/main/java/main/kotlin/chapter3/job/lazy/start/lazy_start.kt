package main.kotlin.chapter3.job.lazy.start

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * This code start a coroutine lazily but doesn't wait
 * for it to complete, so the log entry is never printed.
 */
fun main(args: Array<String>) {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(3000)
        println("job completed")
    }

    job.start()
}
