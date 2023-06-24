package domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterImage: String,
    val releaseDate: String,
)
