package com.task.movie.remote.service

import com.task.movie.remote.model.MovieDetailRemote
import com.task.movie.remote.model.MovieListRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/")
    suspend fun getMovieList(
        @Query("apikey") apiKey: String = "3e974fca",
        @Query("s") movieName: String = "batman",
    ): MovieListRemoteResponse

    @GET("/")
    suspend fun getMovieDetail(
        @Query("apikey") apiKey: String = "3e974fca",
        @Query("i") movieId: String,
    ): MovieDetailRemote

}