package di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

/**
 * created by Josue Lubaki
 * date : 2023-05-17
 * version : 1.0.0
 */

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(getSharedModule())
    }
}