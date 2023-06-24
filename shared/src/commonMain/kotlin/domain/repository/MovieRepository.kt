package domain.repository

import domain.model.Movie
import kotlinx.coroutines.flow.Flow
import utils.network.DataState

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

internal interface MovieRepository {
    suspend fun getMovies(page: Int = 1) : Flow<DataState<List<Movie>>>
    suspend fun getMovie(id: Int) : DataState<Movie>
}