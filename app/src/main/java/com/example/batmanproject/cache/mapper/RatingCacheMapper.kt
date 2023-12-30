package com.task.movie.cache.mapper

import com.task.movie.cache.model.RatingCache
import com.task.movie.data.model.Rating

fun RatingCache.mapToRating(): Rating {
    return Rating(
        source = source,
        value = value
    )
}