
interface Destination {
    val title: String
    val route: String
    val routeWithArgs: String
    val argsName: String
        get() = ""
}

object Home: Destination {
    override val title: String
        get() = "Agents"

    override val route: String
        get() = "home"

    override val routeWithArgs: String
        get() = route
}

object Detail: Destination{
    override val title: String
        get() = "Agent details"

    override val route: String
        get() = "detail"

    override val argsName: String
        get() = "agentUuid"

    override val routeWithArgs: String
        get() = "$route/{$argsName}"
}