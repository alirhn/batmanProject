package com.task.movie.presentation

import com.task.movie.base.BaseViewModel
import com.task.movie.data.model.Movie
import com.task.movie.data.reporitory.MovieRepository
import com.task.movie.ui.screen.movielist.model.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : BaseViewModel<MovieListState>() {

    override val viewModelState: MutableStateFlow<MovieListState> =
        MutableStateFlow(MovieListState())

    init {
        getMovieList()
    }

    private fun getMovieList() {
        getData(
            action = {
                movieRepository.getMovieList()
            },
            onLoadingAction = {
                onGetMovieListLoading()
            },
            onSuccessAction = { data ->
                onGetMovieListSuccess(data = data)
            },
            onErrorAction = { errorMessage ->
                onGetMovieListError(errorMessage)
            }
        )
    }

    private fun onGetMovieListLoading() {
        updateMovieListLoading(isLoading = true)
        updateMovieListData()
        updateMovieListErrorMessage()
    }
    private fun onGetMovieListSuccess(data: List<Movie>) {
        updateMovieListLoading(isLoading = false)
        updateMovieListData(data = data)
        updateMovieListErrorMessage()
    }
    private fun onGetMovieListError(errorMessage: String) {
        updateMovieListLoading(isLoading = false)
        updateMovieListData()
        updateMovieListErrorMessage(errorMessage = errorMessage)
    }

    private fun updateMovieListLoading(isLoading: Boolean) {
        viewModelState.update {
            it.copy(
                movieList = it.movieList.copy(isLoading = isLoading)
            )
        }
    }

    private fun updateMovieListData(data: List<Movie>? = null) {
        viewModelState.update {
            it.copy(
                movieList = it.movieList.copy(data = data)
            )
        }
    }

    private fun updateMovieListErrorMessage(errorMessage: String? = null) {
        viewModelState.update {
            it.copy(
                movieList = it.movieList.copy(errorMessage = errorMessage)
            )
        }
    }
}