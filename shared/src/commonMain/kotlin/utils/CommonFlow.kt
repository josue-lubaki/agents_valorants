package utils

import io.ktor.utils.io.core.Closeable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import utils.network.ListWrapper
import utils.network.Resource

fun <T> Flow<T>.asCommonFlow(): CommonFlow<T> = CommonFlow(this)
class CommonFlow<T>(private val origin: Flow<T>) : Flow<T> by origin {
    fun watch(block: (T) -> Unit): Closeable {
        val job = Job()

        onEach {
            block(it)
        }.launchIn(CoroutineScope(Dispatchers.Main + job))

        return object : Closeable {
            override fun close() {
                job.cancel()
            }
        }
    }
}

fun <T>Flow<Resource<List<T>>>.asListWrapper():Flow<Resource<ListWrapper<T>>> = this
    .map {
        when(it){
            is Resource.Loading -> Resource.Loading(data = ListWrapper(it.data))
            is Resource.Success -> Resource.Success(data = ListWrapper(it.data))
            is Resource.Error -> Resource.Error(data = ListWrapper(it.data), message = it.message)
        }
    }