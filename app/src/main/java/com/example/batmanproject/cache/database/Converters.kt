package com.task.movie.cache.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.task.movie.cache.model.RatingCache

@ProvidedTypeConverter
class Converters{
    @TypeConverter
    fun fromListRating(ratings: List<RatingCache>): String {
        val json = Gson().toJson(ratings)
        return if (json.isNullOrEmpty())
            ""
        else
            json
    }

    @TypeConverter
    fun toListRating(json: String): List<RatingCache> {
        val type = object : TypeToken<List<RatingCache>>() {}.type

        return if (json.isEmpty())
            listOf()
        else
            Gson().fromJson(json, type)
    }

}