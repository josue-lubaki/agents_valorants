package data.model

import kotlinx.serialization.Serializable

/**
 * created by Josue Lubaki
 * date : 2023-06-24
 * version : 1.0.0
 */

@Serializable
data class MovieApiResponse(
    val results: List<MovieRemote>,
)