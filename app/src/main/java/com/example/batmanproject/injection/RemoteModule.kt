package com.task.movie.injection

import com.google.gson.Gson
import com.task.movie.BuildConfig
import com.task.movie.util.MovieConstant.BASE_URL
import com.task.movie.data.source.MovieRemoteSource
import com.task.movie.remote.MovieRemoteSourceImpl
import com.task.movie.remote.service.MovieService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    companion object {

        @Provides
        fun provideMovieService(
            gsonConverterFactory: GsonConverterFactory,
            okHttpClient: OkHttpClient,
        ): MovieService {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build().create(MovieService::class.java)
        }
        @Singleton
        @Provides
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val logging = HttpLoggingInterceptor()
            logging.level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
            return logging
        }

        @Singleton
        @Provides
        fun provideOkHttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        }
        @Provides
        fun provideGsonConverterFactory(): GsonConverterFactory {
            return GsonConverterFactory.create()
        }
        @Singleton
        @Provides
        fun provideGson(): Gson {
            return Gson()
        }

    }

    @Binds
    abstract fun bindMovieRemoteSource(
        movieRemoteSourceImpl: MovieRemoteSourceImpl
    ): MovieRemoteSource

}