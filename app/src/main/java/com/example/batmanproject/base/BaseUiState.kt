package com.task.movie.base

data class BaseUiState<T>(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val data: T? = null
)
