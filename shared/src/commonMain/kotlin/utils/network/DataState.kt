package utils.network

/**
 * created by Josue Lubaki
 * date : 2023-05-08
 * version : 1.0.0
 */

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}