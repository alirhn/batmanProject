package com.task.movie.presentation

import androidx.lifecycle.SavedStateHandle
import com.task.movie.base.BaseViewModel
import com.task.movie.data.model.MovieDetail
import com.task.movie.data.reporitory.MovieRepository
import com.task.movie.ui.navigation.MovieDestinationsArgs
import com.task.movie.ui.screen.moviedetail.model.MovieDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<MovieDetailState>() {

    private val movieId: String? = savedStateHandle[MovieDestinationsArgs.MOVIE_ID_ARG]

    override val viewModelState: MutableStateFlow<MovieDetailState> =
        MutableStateFlow(MovieDetailState())

    init {
        if (movieId != null){
            getMovieDetail(movieId)
        } else {
            updateMovieDetailErrorMessage("Movie id is null")
        }
    }

    private fun getMovieDetail(movieId: String) {
        getData(
            action = {
                movieRepository.getMovieDetail(movieId = movieId)
            },
            onLoadingAction = {
                onGetMovieDetailLoading()
            },
            onSuccessAction = { data ->
                onGetMovieDetailSuccess(data = data)
            },
            onErrorAction = { errorMessage ->
                onGetMovieDetailError(errorMessage)
            }
        )
    }

    private fun onGetMovieDetailLoading() {
        updateMovieDetailLoading(isLoading = true)
        updateMovieDetailData()
        updateMovieDetailErrorMessage()
    }
    private fun onGetMovieDetailSuccess(data: MovieDetail) {
        updateMovieDetailLoading(isLoading = false)
        updateMovieDetailData(data = data)
        updateMovieDetailErrorMessage()
    }
    private fun onGetMovieDetailError(errorMessage: String) {
        updateMovieDetailLoading(isLoading = false)
        updateMovieDetailData()
        updateMovieDetailErrorMessage(errorMessage = errorMessage)
    }
    private fun updateMovieDetailLoading(isLoading: Boolean) {
        viewModelState.update {
            it.copy(
                movieDetail = it.movieDetail.copy(isLoading = isLoading)
            )
        }
    }

    private fun updateMovieDetailData(data: MovieDetail? = null) {
        viewModelState.update {
            it.copy(
                movieDetail = it.movieDetail.copy(data = data)
            )
        }
    }

    private fun updateMovieDetailErrorMessage(errorMessage: String? = null) {
        viewModelState.update {
            it.copy(
                movieDetail = it.movieDetail.copy(errorMessage = errorMessage)
            )
        }
    }


}