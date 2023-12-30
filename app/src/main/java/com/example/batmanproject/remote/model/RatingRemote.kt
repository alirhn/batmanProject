package com.task.movie.remote.model

import com.google.gson.annotations.SerializedName

data class RatingRemote(
    @SerializedName("Source")
    val source: String,
    @SerializedName("Value")
    val value: String,
)