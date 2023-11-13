package com.emirtemindarov.lr3_1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlin.concurrent.thread
import kotlinx.coroutines.launch
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            noSynchronized()
            synchronized()
            reentrantLock()
        }
    }
}

fun noSynchronized() {
    val n = 5
    val m = 5
    val iterations = 100000
    val noSynchronizedCounter = NoSynchronizedCounter()

    val noSynchronizedtime = measureTimeMillis {
        val NThreads = List(n) {
            thread {
                for (i in 0 until iterations) {
                    noSynchronizedCounter.increment()
                }
            }
        }

        val MThreads = List(m) {
            thread {
                for (i in 0 until iterations) {
                    noSynchronizedCounter.decrement()
                }
            }
        }

        NThreads.forEach { it.join() }
        MThreads.forEach { it.join() }
    }

    Log.d("NoSynchronizedCounter", "Значение счетчика: ${noSynchronizedCounter.value()}")
    Log.d("NoSynchronizedTime", "Время выполнения: $noSynchronizedtime миллисекунд")
}

fun synchronized() = runBlocking {
    val n = 5
    val m = 5
    val iterations = 100000
    val synchronizedCounter = SynchronizedCounter()

    val synchronizedTime = measureTimeMillis {
        val NThreads = List(n) {
            thread {
                for (i in 0 until iterations) {
                    launch {
                        synchronizedCounter.increment()
                    }
                }
            }
        }

        val MThreads = List(m) {
            thread {
                for (i in 0 until iterations) {
                    launch {
                        synchronizedCounter.decrement()
                    }
                }
            }
        }

        NThreads.forEach { it.join() }
        MThreads.forEach { it.join() }
    }

    Log.d("SynchronizedCounter", "Значение счетчика: ${synchronizedCounter.value()}")
    Log.d("SynchronizedTime", "Время выполнения: $synchronizedTime миллисекунд")
}

fun reentrantLock() = runBlocking {
    val n = 5
    val m = 5
    val iterations = 100000
    val reentrantLockCounter = ReentrantLockCounter()

    val reentrantLockTime = measureTimeMillis {
        val NThreads = List(n) {
            thread {
                for (i in 0 until iterations) {
                    launch {
                        reentrantLockCounter.increment()
                    }
                }
            }
        }

        val MThreads = List(m) {
            thread {
                for (i in 0 until iterations) {
                    launch {
                        reentrantLockCounter.decrement()
                    }
                }
            }
        }

        NThreads.forEach { it.join() }
        MThreads.forEach { it.join() }
    }

    Log.d("ReentrantLockCounter", "Значение счетчика: ${reentrantLockCounter.value()}")
    Log.d("ReentrantLockTime", "Время выполнения: $reentrantLockTime миллисекунд")
}

