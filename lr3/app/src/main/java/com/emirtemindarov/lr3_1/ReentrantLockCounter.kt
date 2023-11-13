package com.emirtemindarov.lr3_1

import java.util.concurrent.locks.ReentrantLock

class ReentrantLockCounter {
    private var value = 0
    private val lock = ReentrantLock()

    suspend fun increment() {
        lock.lock()
        value++
        lock.unlock()
    }

    suspend fun decrement() {
        lock.lock()
        value--
        lock.unlock()
    }

    fun value(): Int {
        return value
    }
}
