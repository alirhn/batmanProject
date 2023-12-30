package com.task.movie.cache.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RatingCache(
    @SerializedName("source")
    val source: String,
    @SerializedName("value")
    val value: String,
): Serializable
