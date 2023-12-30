package com.task.movie.cache.mapper

import com.task.movie.cache.model.MovieDetailCache
import com.task.movie.data.model.MovieDetail

fun MovieDetailCache.mapToMovieDetail(): MovieDetail {
    return MovieDetail(
        title = title,
        year = year,
        rated = rated,
        released = released,
        runtime = runtime,
        genre = genre,
        director = director,
        writer = writer,
        actors = actors,
        plot = plot,
        language = language,
        country = country,
        awards = awards,
        poster = poster,
        metaScore = metaScore,
        imdbRating = imdbRating,
        imdbVotes = imdbVotes,
        imdbID = id,
        type = type,
        dvd = dvd,
        boxOffice = boxOffice,
        ratings = ratings.map { it.mapToRating() },
    )
}