package di

import kotlinx.coroutines.CoroutineDispatcher
import org.koin.dsl.module

/**
 * created by Josue Lubaki
 * date : 2023-05-16
 * version : 1.0.0
 */

private val dataModule = module {

}

private val utilityModule = module {

}

private val domainModule = module {

}

private val _sharedModule = listOf(dataModule, utilityModule, domainModule)

fun getSharedModule() = _sharedModule
