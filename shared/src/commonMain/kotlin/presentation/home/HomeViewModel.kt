package presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import domain.usecases.GetAllAgentsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.network.Resource

/**
 * created by Josue Lubaki
 * date : 2023-04-30
 * version : 1.0.0
 */

class HomeViewModel : ViewModel(), KoinComponent {
    private val getMoviesUseCase: GetAllAgentsUseCase by inject()
    private val dispatchers : CoroutineDispatcher by inject()

    var uiState by mutableStateOf(HomeState())

    fun loadMovies(forceReload: Boolean) {
        if(uiState.loading) return

        viewModelScope.launch(dispatchers) {
            getMoviesUseCase().collect {
                when(it) {
                    is Resource.Loading -> {
                        uiState = uiState.copy(loading = true)
                    }

                    is Resource.Error -> {
                        uiState = uiState.copy(
                            loading = false,
                            refreshing = false
                        )
                    }
                    is Resource.Success -> {
                        uiState = uiState.copy(
                            loading = false,
                            refreshing = false,
                            agents = it.data?.items,
                            errorMessage = null,
                            loadFinished = true
                        )
                    }
                }
            }
        }
    }
}