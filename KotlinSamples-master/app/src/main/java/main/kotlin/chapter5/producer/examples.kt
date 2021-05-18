package main.kotlin.chapter5.producer

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>)= runBlocking {
    creation()
    readingAllTheElements()
    singleElement()
    groupOfElements()
    moreThanAvailable()
    moreThanAvailableException()
}

suspend fun creation() {

    // Simple producer
    val simpleProducer = GlobalScope.produce {
        send(1)
    }
    println(simpleProducer.receive())

    // Producer with a CoroutineContext
    val context = newSingleThreadContext("myThread")
    val producerWithContext = GlobalScope.produce(context) {
        for (i in 0..9) {
            println("sending $i")
            send(i)
        }
    }

    producerWithContext.take(12).consumeEach {
        println(it)
    }

    // Typed producer
    val typedProducer : ReceiveChannel<Any> = GlobalScope.produce(context) {
        send(5)
        send("a")
    }
}

suspend fun readingAllTheElements() {
    val context = newSingleThreadContext("myThread")

    val producer = GlobalScope.produce(context) {
        for (i in 0..9) {
            send(i)
        }
    }

    producer.consumeEach {
        println(it)
    }
}

suspend fun singleElement() {
    val producer = GlobalScope.produce {
        send(5)
        send("a")
    }

    println(producer.receive())
    println(producer.receive())
}

suspend fun groupOfElements() {
    val producer = GlobalScope.produce {
        for (i in 0..9) {
            send(i)
        }
    }

    producer.take(3).consumeEach {
        println(it)
    }
}

suspend fun moreThanAvailable() {
    val producer = GlobalScope.produce {
        for (i in 0..9) {
            send(i)
        }
    }

    producer.take(12).consumeEach {
        println(it)
    }
}

suspend fun moreThanAvailableException() {
    val producer = GlobalScope.produce {
        for (i in 0..9) {
            send(i)
        }
    }

    producer.take(12).consumeEach {
        println(it)
    }

    // This line below would produce an exception
    // val element = producer.receive()
}
