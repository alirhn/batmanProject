package com.task.movie.data.source

import com.task.movie.cache.model.MovieCache
import com.task.movie.cache.model.MovieDetailCache
import com.task.movie.data.model.Movie
import com.task.movie.data.model.MovieDetail

interface MovieCacheSource {

    suspend fun getMovieList(): List<Movie>

    suspend fun saveMovies(movies: List<MovieCache>)

    suspend fun getMovieDetail(movieId: String): MovieDetail

    suspend fun saveMovieDetail(movieDetail: MovieDetailCache)
}