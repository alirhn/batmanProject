package com.task.movie.injection

import android.app.Application
import com.task.movie.cache.MovieCacheSourceImpl
import com.task.movie.cache.dao.MovieDao
import com.task.movie.cache.database.MovieDatabase
import com.task.movie.data.source.MovieCacheSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    companion object {

        @Singleton
        @Provides
        fun provideMetroDatabase(
            application: Application,
        ): MovieDatabase {
            return MovieDatabase.getInstance(
                context = application,
            )
        }

        @Singleton
        @Provides
        fun provideMovieDao(database: MovieDatabase): MovieDao {
            return database.movieDao()
        }

    }

    @Binds
    abstract fun bindMovieCache(movieCacheSourceImpl: MovieCacheSourceImpl): MovieCacheSource


}