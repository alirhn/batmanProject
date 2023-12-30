package com.task.movie.ui.screen.movielist.model

import com.task.movie.base.BaseUiState
import com.task.movie.data.model.Movie

data class MovieListState(
    val movieList: BaseUiState<List<Movie>> = BaseUiState()
)
