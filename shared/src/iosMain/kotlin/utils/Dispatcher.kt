package utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * created by Josue Lubaki
 * date : 2023-06-24
 * version : 1.0.0
 */

internal class IosAppDispatcher : AppDispatcher {
    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.Main
}

internal actual fun provideDispatcher(): AppDispatcher = IosAppDispatcher()