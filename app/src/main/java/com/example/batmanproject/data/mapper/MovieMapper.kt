package com.task.movie.data.mapper

import com.task.movie.cache.model.MovieCache
import com.task.movie.data.model.Movie

fun Movie.mapToMovieCache(): MovieCache {
    return MovieCache(
        id = id,
        title = title,
        year = year,
        type = type,
        poster = poster
    )
}