package data.repository

import data.mapper.toDomain
import domain.model.Movie
import utils.network.DataState
import data.datasource.RemoteDataSource
import domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : MovieRepository {

    override suspend fun getMovies(page: Int): Flow<DataState<List<Movie>>> = flow {
        emit(DataState.Loading)
        try {
            val result = remoteDataSource.getMovies(page).results.map {
                it.toDomain()
            }
            emit(DataState.Success(result))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

    override suspend fun getMovie(id: Int): DataState<Movie> {
        return try {
            val result = remoteDataSource.getMovie(id).toDomain()
            DataState.Success(result)
        } catch (e: Exception) {
            DataState.Error(e)
        }
    }
}