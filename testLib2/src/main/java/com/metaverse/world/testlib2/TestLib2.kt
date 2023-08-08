package com.metaverse.world.testlib2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class TestLib2(
    val text: String
) {

    fun test() {
        println("test")
    }

    suspend fun test2() {
        withContext(Dispatchers.IO) {
            println("test2")
            delay(200)
        }


    }


}