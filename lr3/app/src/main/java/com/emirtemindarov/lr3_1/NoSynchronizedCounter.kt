package com.emirtemindarov.lr3_1

class NoSynchronizedCounter {
    private var value = 0

    fun increment() {
        value++
    }

    fun decrement() {
        value--
    }

    fun value(): Int {
        return value
    }
}