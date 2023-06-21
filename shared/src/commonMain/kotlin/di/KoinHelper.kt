package di

import org.koin.core.context.startKoin

/**
 * created by Josue Lubaki
 * date : 2023-05-17
 * version : 1.0.0
 */

fun initKoin() {
    startKoin {
        modules(getSharedModule())
    }
}