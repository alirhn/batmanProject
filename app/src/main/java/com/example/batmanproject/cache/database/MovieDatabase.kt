package com.task.movie.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.task.movie.cache.dao.MovieDao
import com.task.movie.cache.model.MovieCache
import com.task.movie.cache.model.MovieDetailCache
import com.task.movie.util.MovieConstant.MOVIE_DB

@Database(
    entities = [MovieCache::class, MovieDetailCache::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        private var INSTANCE: MovieDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): MovieDatabase {
            if (INSTANCE == null) {
                synchronized(lock) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            MovieDatabase::class.java, MOVIE_DB
                        )
                            .addTypeConverter(Converters())
                            .build()
                    }
                    return INSTANCE as MovieDatabase
                }
            }
            return INSTANCE as MovieDatabase
        }
    }
}
