package com.task.movie.data.mapper

import com.task.movie.cache.model.RatingCache
import com.task.movie.data.model.Rating

fun Rating.mapToRatingCache(): RatingCache {
    return RatingCache(
        source = source,
        value = value
    )
}