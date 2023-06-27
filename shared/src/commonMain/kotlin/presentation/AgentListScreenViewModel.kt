package presentation

import domain.usecases.GetAllAgentsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import state.MainUiState
import utils.network.Resource

class AgentListScreenViewModel : ViewModel(), KoinComponent {
    private val getAllAgentsUseCase: GetAllAgentsUseCase by inject()

    private val _uiState = MutableStateFlow(MainUiState())
    internal val uiState get() = _uiState.asStateFlow()

    init {
        loadAgentList()
    }

    fun loadAgentList() {
        viewModelScope.launch {
            getAllAgentsUseCase().flowOn(Dispatchers.Main).collectLatest {
                when (it) {
                    is Resource.Loading -> {
                        _uiState.update { state ->
                            state.copy(
                                isLoading = true,
                                isError = false,
                                agents = it.data?.items ?: emptyList()
                            )
                        }
                    }

                    is Resource.Success -> {
                        _uiState.update { state ->
                            state.copy(
                                isLoading = false,
                                agents = it.data?.items ?: emptyList()
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update { state ->
                            state.copy(
                                isLoading = false,
                                isError = true,
                                agents = it.data?.items ?: emptyList(),
                                message = it.message
                            )
                        }
                    }
                }
            }
        }
    }
}
