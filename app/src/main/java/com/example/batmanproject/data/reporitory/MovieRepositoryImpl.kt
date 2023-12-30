package com.task.movie.data.reporitory

import com.task.movie.data.datastore.MovieCacheDataStore
import com.task.movie.data.datastore.MovieRemoteDataStore
import com.task.movie.data.model.MovieDetail
import com.task.movie.util.apiCall
import com.task.movie.util.cacheCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataStore: MovieRemoteDataStore,
    private val cacheDataStore: MovieCacheDataStore,
): MovieRepository {

    override suspend fun getMovieList() = flow {
        val cacheResult = cacheCall { cacheDataStore.getMovieList() }

        cacheResult.onSuccess { result ->
            emit(Result.success(value = result))
        }

        val remoteResult = apiCall { remoteDataStore.getMovieList() }

        remoteResult.onSuccess { result ->
            cacheDataStore.saveMovies(result)
            emit(Result.success(value = result))
        }

        remoteResult.onFailure {
            if (cacheResult.isFailure){
                emit(remoteResult)
            }
        }
    }

    override suspend fun getMovieDetail(movieId: String): Flow<Result<MovieDetail>> = flow {
        val cacheResult = cacheCall { cacheDataStore.getMovieDetail(movieId) }

        cacheResult.onSuccess { result ->
            emit(Result.success(value = result))
        }

        val remoteResult = apiCall { remoteDataStore.getMovieDetail(movieId) }

        remoteResult.onSuccess { result ->
            cacheDataStore.saveMovieDetail(result)
            emit(Result.success(value = result))
        }

        remoteResult.onFailure {
            if (cacheResult.isFailure){
                emit(remoteResult)
            }
        }
    }

}