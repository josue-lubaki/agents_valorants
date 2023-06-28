package presentation.detail

import androidx.compose.runtime.mutableStateOf
import domain.model.Agent
import domain.usecases.GetAgentUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.network.Resource

/**
 * created by Josue Lubaki
 * date : 2023-05-02
 * version : 1.0.0
 */

class DetailViewModel : ViewModel(), KoinComponent {

    private val getAgentUseCase: GetAgentUseCase by inject()
    private val dispatchers : CoroutineDispatcher by inject()

    private var _state = MutableStateFlow<DetailState>(DetailState.Idle)
    val state: StateFlow<DetailState> = _state.asStateFlow()
    val agentDetails = mutableStateOf<Agent?>(null)

    fun loadMovie(agentId: String) {
        _state.value = DetailState.Loading
        viewModelScope.launch(dispatchers) {
            getAgentUseCase(agentId).collect {
                when(it) {
//            when(val result = getAgentUseCase(agentId)) {
                    is Resource.Error -> {
                        _state.value = DetailState.Error(
                            errorMessage = it.message,
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = DetailState.Loading
                    }
                    is Resource.Success -> {
                        agentDetails.value = it.data?.items?.first()
                        _state.value = DetailState.Success(
                            agent = it.data?.items?.first()
                        )
                    }
                }
            }
        }
    }
}