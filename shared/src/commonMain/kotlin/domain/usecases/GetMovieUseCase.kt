package domain.usecases

import domain.model.Movie
import domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.network.DataState

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

class GetMovieUseCase : KoinComponent {
    private val movieRepositoryImpl by inject<MovieRepository>()

    @Throws(Exception::class)
    suspend operator fun invoke(id: Int) : DataState<Movie> = movieRepositoryImpl.getMovie(id)
}
