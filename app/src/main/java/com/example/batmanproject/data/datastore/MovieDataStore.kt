package com.task.movie.data.datastore

import com.task.movie.data.model.Movie
import com.task.movie.data.model.MovieDetail

interface MovieDataStore {

    suspend fun getMovieList(): List<Movie>

    suspend fun saveMovies(movies: List<Movie>)

    suspend fun getMovieDetail(movieId: String): MovieDetail

    suspend fun saveMovieDetail(movieDetail: MovieDetail)

}