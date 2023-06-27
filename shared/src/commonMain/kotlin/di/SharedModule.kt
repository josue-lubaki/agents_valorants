package di

import com.myapplication.database.AgentXDatabase
import data.api.AgentXService
import data.datasource.LocalDataSource
import data.datasource.RemoteDataSource
import data.datasourceimpl.LocalDataSourceImpl
import data.datasourceimpl.RemoteDataSourceImpl
import data.db.createDatabase
import data.db.sqlDriverFactory
import data.repository.AgentRepositoryImpl
import domain.repository.AgentRepository
import domain.usecases.GetAllAgentsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.dsl.module
import utils.provideDispatcher

/**
 * created by Josue Lubaki
 * date : 2023-05-16
 * version : 1.0.0
 */

private val dataModule = module {
    single { sqlDriverFactory() }
    factory { AgentXService() }
    single<AgentXDatabase> { createDatabase(driver = get()) }
    single<LocalDataSource> { LocalDataSourceImpl(get()) }
    single<RemoteDataSource> { RemoteDataSourceImpl(get(), get()) }
}

private val utilityModule = module {
    factory<CoroutineDispatcher> { provideDispatcher().dispatcher }
}

private val domainModule = module {
    single<AgentRepository> { AgentRepositoryImpl(get(), get()) }
    single<GetAllAgentsUseCase> { GetAllAgentsUseCase() }
}

private val _sharedModule = listOf(dataModule, utilityModule, domainModule)

fun getSharedModule() = _sharedModule
