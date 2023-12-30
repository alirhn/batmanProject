package com.task.movie.remote.mapper

import com.task.movie.data.model.MovieDetail
import com.task.movie.remote.model.MovieDetailRemote

fun MovieDetailRemote.mapToMovieDetail(): MovieDetail {
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
        imdbID = imdbID,
        type = type,
        dvd = dvd,
        boxOffice = boxOffice,
        ratings = ratings.map { it.mapToRating() },
    )
}