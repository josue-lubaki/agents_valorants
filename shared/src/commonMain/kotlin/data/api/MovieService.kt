package data.api

import data.model.MovieApiResponse
import data.model.MovieRemote
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

/**
 * created by Josue Lubaki
 * date : 2023-06-24
 * version : 1.0.0
 */

internal class MovieService : Api() {
    suspend fun getMovies(page: Int = 1) : MovieApiResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovie(id: Int) : MovieRemote = client.get {
        pathUrl("movie/$id")
    }.body()
}