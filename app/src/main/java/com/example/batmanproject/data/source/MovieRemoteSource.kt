package com.task.movie.data.source

import com.task.movie.data.model.Movie
import com.task.movie.data.model.MovieDetail

interface MovieRemoteSource {

    suspend fun getMovieList(): List<Movie>

    suspend fun getMovieDetail(movieId: String): MovieDetail
}