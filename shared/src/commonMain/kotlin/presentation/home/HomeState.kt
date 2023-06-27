package presentation.home

import domain.model.Agent

data class HomeState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var agents: List<Agent>? = listOf(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false,
)
