package main.kotlin.chapter6.interaction.send

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedSendChannelException
import kotlinx.coroutines.channels.take
import kotlinx.coroutines.runBlocking

/**
 * Interaction with a SendChannel
 */
fun main(args: Array<String>) = runBlocking {
    isClosed()
    //isFull()  // Deprecated (https://github.com/Kotlin/kotlinx.coroutines/issues/1053)
    send()
    sendException()
    offerException()
    offerWhenFull()
    offer()
}

fun isClosed() {
    val channel = Channel<Int>()
    channel.isClosedForSend // false
    channel.close()
    channel.isClosedForSend // true
}

suspend fun isFull() {
    val channel = Channel<Int>(1)
    //channel.isFull // false   // Deprecated (https://github.com/Kotlin/kotlinx.coroutines/issues/1053)
    channel.send(1)
    //channel.isFull // true   // Deprecated (https://github.com/Kotlin/kotlinx.coroutines/issues/1053)
}

suspend fun send() {
    val channel = Channel<Int>(1)
    channel.send(1)
}

suspend fun sendException() {
    val channel = Channel<Int>(1)
    channel.close()

    try {
        channel.send(1)
    } catch (e : ClosedSendChannelException) {
        println("ClosedSendChannelException handled")
    }

}

fun offerException() {
    val channel = Channel<Int>(1)
    channel.close()

    try {
        channel.offer(10)
    } catch (e : ClosedSendChannelException) {
        println("ClosedSendChannelException handled")
    }
}

suspend fun offerWhenFull() {
    val channel = Channel<Int>(1)
    channel.send(1)
    channel.offer(2) // false
}

suspend fun offer() {
    val channel = Channel<Int>(1)
    channel.offer(2) // false
    channel.receive() // 2
}