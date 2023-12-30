package com.task.movie.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieCache(
    @PrimaryKey
    val id: String,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("year")
    val year: String,
    @ColumnInfo("type")
    val type: String,
    @ColumnInfo("poster")
    val poster: String,
)
