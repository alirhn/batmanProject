package com.task.movie.ui.screen.moviedetail.model

import com.task.movie.base.BaseUiState
import com.task.movie.data.model.MovieDetail

data class MovieDetailState(
    val movieDetail: BaseUiState<MovieDetail> = BaseUiState()
)
