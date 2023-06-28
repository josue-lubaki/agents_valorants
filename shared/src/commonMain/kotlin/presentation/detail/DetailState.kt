package presentation.detail

import domain.model.Agent


sealed class DetailState {
    object Idle: DetailState()
    object Loading: DetailState()
    data class Success(val agent: Agent?): DetailState()
    data class Error(val errorMessage: String?): DetailState()
}