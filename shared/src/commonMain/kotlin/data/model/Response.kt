package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Response<T> (
    val status:Int,
    val data:T
)