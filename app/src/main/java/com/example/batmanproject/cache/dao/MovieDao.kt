package com.task.movie.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.task.movie.cache.model.MovieCache
import com.task.movie.cache.model.MovieDetailCache

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<MovieCache>)

    @Query("SELECT * FROM movie")
    suspend fun getMovieList(): List<MovieCache>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieDetail(movieDetailCache: MovieDetailCache)

    @Query("SELECT * FROM movie_detail WHERE id = :movieId")
    suspend fun getMovieDetail(movieId: String): MovieDetailCache

}