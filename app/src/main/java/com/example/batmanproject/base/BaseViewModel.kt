package com.task.movie.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class BaseViewModel<T> : ViewModel() {

    protected abstract val viewModelState: MutableStateFlow<T>

    val uiState by lazy {
        viewModelState
            .stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                viewModelState.value
            )
    }

    protected fun <T : Any> getData(
        action: suspend () -> Flow<Result<T>>,
        onLoadingAction: () -> Unit = {},
        onSuccessAction: (T) -> Unit = {},
        onErrorAction: (String) -> Unit = {},
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            onLoadingAction()

            val a = action()
            action().collect { result ->
                result.onSuccess {
                    result.getOrNull().let { data ->
                        if (data == null){
                            onErrorAction("Data not exist")
                        } else {
                            onSuccessAction(data)
                        }
                    }
                }
                result.onFailure {
                    result.exceptionOrNull().let { exception ->
                        if (exception == null){
                            onErrorAction("Exception is null")
                        } else {
                            onErrorAction(exception.message?:"Exception message is null")
                        }
                    }
                }
            }
        }
    }

}