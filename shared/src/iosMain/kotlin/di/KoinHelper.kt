package di

import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * created by Josue Lubaki
 * date : 2023-06-25
 * version : 1.0.0
 */


fun initKoin() = module {
    startKoin {
        modules(getSharedModule())
    }
}