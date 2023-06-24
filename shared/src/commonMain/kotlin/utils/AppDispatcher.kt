package utils

import kotlinx.coroutines.CoroutineDispatcher

/**
 * created by Josue Lubaki
 * date : 2023-05-17
 * version : 1.0.0
 */
internal interface AppDispatcher {
    val dispatcher : CoroutineDispatcher
}
internal expect fun provideDispatcher() : AppDispatcher