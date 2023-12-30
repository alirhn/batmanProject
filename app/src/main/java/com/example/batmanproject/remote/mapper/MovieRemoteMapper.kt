package com.task.movie.remote.mapper

import com.task.movie.data.model.Movie
import com.task.movie.remote.model.MovieRemote

fun MovieRemote.mapToMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        year = year,
        type = type,
        poster = poster
    )
}