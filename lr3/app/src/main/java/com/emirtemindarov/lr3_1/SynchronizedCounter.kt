package com.emirtemindarov.lr3_1

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class SynchronizedCounter {
    private var value = 0
    private val mutex = Mutex()

    suspend fun increment() {
        mutex.withLock {
            value++
        }
    }

    suspend fun decrement() {
        mutex.withLock {
            value--
        }
    }

    fun value(): Int {
        return value
    }
}
