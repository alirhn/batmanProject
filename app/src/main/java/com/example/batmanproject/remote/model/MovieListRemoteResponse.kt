package com.task.movie.remote.model

import com.google.gson.annotations.SerializedName

data class MovieListRemoteResponse(
    @SerializedName("Search")
    val listMovies: List<MovieRemote>
)
