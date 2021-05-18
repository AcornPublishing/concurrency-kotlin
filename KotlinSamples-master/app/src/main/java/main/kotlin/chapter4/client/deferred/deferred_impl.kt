package main.kotlin.chapter4.client.deferred

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * Implementation using deferred.
 */
fun main(args: Array<String>) = runBlocking {
    val client : ProfileServiceRepository = ProfileServiceClient()

    val profile = client.asyncFetchByIdAsync(12).await()
    println(profile)
}

data class Profile(val id: Long, val name: String, val age: Int)

interface ProfileServiceRepository {
    fun asyncFetchByNameAsync(name: String) : Deferred<Profile>
    fun asyncFetchByIdAsync(id: Long) : Deferred<Profile>
}

class ProfileServiceClient : ProfileServiceRepository {
    override fun asyncFetchByNameAsync(name: String) = GlobalScope.async {
        Profile(1, name, 28)
    }

    override fun asyncFetchByIdAsync(id: Long) = GlobalScope.async {
        Profile(id, "Susan", 28)
    }
}