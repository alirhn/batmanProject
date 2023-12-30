package com.task.movie.util

inline fun <T> cacheCall(cacheAction: () -> T): Result<T> {
    return runCatching { cacheAction() }
}