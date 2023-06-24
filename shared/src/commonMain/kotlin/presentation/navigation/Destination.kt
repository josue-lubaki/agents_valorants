
interface Destination {
    val title: String
    val route: String
    val routeWithArgs: String
    val argsName: String
        get() = ""
}

object Home: Destination {
    override val title: String
        get() = "Movies"

    override val route: String
        get() = "home"

    override val routeWithArgs: String
        get() = route
}

object Detail: Destination{
    override val title: String
        get() = "Movie details"

    override val route: String
        get() = "detail"

    override val argsName: String
        get() = "movieId"

    override val routeWithArgs: String
        get() = "$route/{$argsName}"
}