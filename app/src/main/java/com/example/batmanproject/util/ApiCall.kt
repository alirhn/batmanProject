package com.task.movie.util

inline fun <T> apiCall(apiAction: () -> T): Result<T> {
    return runCatching { apiAction() }
}