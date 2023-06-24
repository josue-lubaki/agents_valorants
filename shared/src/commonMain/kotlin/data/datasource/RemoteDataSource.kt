package data.datasource

import data.model.MovieApiResponse
import data.model.MovieRemote

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

internal interface RemoteDataSource {
    suspend fun getMovies(page: Int = 1) : MovieApiResponse
    suspend fun getMovie(id: Int) : MovieRemote
}