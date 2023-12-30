package com.task.movie.cache

import com.task.movie.cache.dao.MovieDao
import com.task.movie.cache.mapper.mapToMovie
import com.task.movie.cache.mapper.mapToMovieDetail
import com.task.movie.cache.model.MovieCache
import com.task.movie.cache.model.MovieDetailCache
import com.task.movie.data.model.Movie
import com.task.movie.data.model.MovieDetail
import com.task.movie.data.source.MovieCacheSource
import javax.inject.Inject

class MovieCacheSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
): MovieCacheSource {

    override suspend fun getMovieList(): List<Movie> {
        val result = movieDao.getMovieList()
        return result.map { it.mapToMovie() }
    }

    override suspend fun saveMovies(movies: List<MovieCache>) {
        movieDao.saveMovies(movies = movies)
    }

    override suspend fun getMovieDetail(movieId: String): MovieDetail {
        val result = movieDao.getMovieDetail(movieId)
        return result.mapToMovieDetail()
    }

    override suspend fun saveMovieDetail(movieDetail: MovieDetailCache) {
        movieDao.saveMovieDetail(movieDetail)
    }

}