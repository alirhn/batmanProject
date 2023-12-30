package com.task.movie.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_detail")
data class MovieDetailCache(
    @PrimaryKey
    val id: String,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("year")
    val year: String,
    @ColumnInfo("rated")
    val rated: String,
    @ColumnInfo("released")
    val released: String,
    @ColumnInfo("runtime")
    val runtime: String,
    @ColumnInfo("genre")
    val genre: String,
    @ColumnInfo("director")
    val director: String,
    @ColumnInfo("writer")
    val writer: String,
    @ColumnInfo("actors")
    val actors: String,
    @ColumnInfo("plot")
    val plot: String,
    @ColumnInfo("Language")
    val language: String,
    @ColumnInfo("country")
    val country: String,
    @ColumnInfo("awards")
    val awards: String,
    @ColumnInfo("poster")
    val poster: String,
    @ColumnInfo("meta_score")
    val metaScore: String,
    @ColumnInfo("imdbRating")
    val imdbRating: String,
    @ColumnInfo("imdbVotes")
    val imdbVotes: String,
    @ColumnInfo("type")
    val type: String,
    @ColumnInfo("dvd")
    val dvd: String,
    @ColumnInfo("boxOffice")
    val boxOffice: String,
    @ColumnInfo("ratings")
    val ratings: List<RatingCache>
)
