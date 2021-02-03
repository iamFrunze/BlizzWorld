package com.byfrunze.blizzworld.data.entities

sealed class Try<out T> {

    data class Success<out T>(val value: T) : Try<T>() {
        override fun getOrNull(): T? = value
    }

    data class Failure<out T>(val cause: Throwable) : Try<T>() {
        override fun getOrNull(): T? = null
    }

    abstract fun getOrNull(): T?
}