package di

import data.api.MovieService
import data.datasource.RemoteDataSource
import data.datasourceimpl.RemoteDataSourceImpl
import data.repository.MovieRepositoryImpl
import domain.repository.MovieRepository
import domain.usecases.GetMovieUseCase
import domain.usecases.GetMoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.dsl.module
import utils.provideDispatcher

/**
 * created by Josue Lubaki
 * date : 2023-05-16
 * version : 1.0.0
 */

private val dataModule = module {
    factory { MovieService() }
    factory<RemoteDataSource> { RemoteDataSourceImpl(get(), get()) }
}

private val utilityModule = module {
    factory<CoroutineDispatcher> { provideDispatcher().dispatcher }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }

    single { GetMoviesUseCase() }
    single { GetMovieUseCase() }
}

private val _sharedModule = listOf(dataModule, utilityModule, domainModule)

fun getSharedModule() = _sharedModule
