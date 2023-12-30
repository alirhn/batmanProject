package com.task.movie.data.reporitory

import com.task.movie.data.model.Movie
import com.task.movie.data.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMovieList(): Flow<Result<List<Movie>>>

    suspend fun getMovieDetail(movieId: String): Flow<Result<MovieDetail>>

}