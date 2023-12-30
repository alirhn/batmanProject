package com.task.movie.cache.mapper

import com.task.movie.cache.model.MovieCache
import com.task.movie.data.model.Movie


fun MovieCache.mapToMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        year = year,
        type = type,
        poster = poster
    )
}