package com.task.movie.presentation

import androidx.lifecycle.viewModelScope
import com.task.movie.base.BaseViewModel
import com.task.movie.ui.screen.splash.model.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): BaseViewModel<SplashState>() {

    override val viewModelState: MutableStateFlow<SplashState> = MutableStateFlow(SplashState())

    init {
        viewModelScope.launch {
            delay(2000)
            updateFinishSplashScreen(finishSplashScreen = true)
        }
    }

    fun updateFinishSplashScreen(finishSplashScreen: Boolean){
        viewModelState.update {
            it.copy(
                finishSplashScreen = finishSplashScreen
            )
        }
    }

}