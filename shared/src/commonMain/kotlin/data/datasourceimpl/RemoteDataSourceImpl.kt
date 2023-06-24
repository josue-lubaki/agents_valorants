package data.datasourceimpl

import data.api.MovieService
import data.datasource.RemoteDataSource
import data.model.MovieApiResponse
import data.model.MovieRemote
import io.ktor.util.logging.Logger
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
//import ca.josue_lubaki.kmmexperiments.util.Dispatcher
import kotlinx.coroutines.withContext

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

internal class RemoteDataSourceImpl(
    private val movieService: MovieService,
    private val dispatcher: CoroutineDispatcher
) : RemoteDataSource {

    override suspend fun getMovie(id: Int): MovieRemote {
        return withContext(dispatcher) {
            movieService.getMovie(id)
        }
    }

    override suspend fun getMovies(page: Int): MovieApiResponse {
        return withContext(Dispatchers.Main) {
            movieService.getMovies(page)
        }
    }
}