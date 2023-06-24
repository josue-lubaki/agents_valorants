package presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import domain.usecases.GetMoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.network.DataState

/**
 * created by Josue Lubaki
 * date : 2023-04-30
 * version : 1.0.0
 */

class HomeViewModel : ViewModel(), KoinComponent {
    private val getMoviesUseCase: GetMoviesUseCase by inject()
    private val dispatchers : CoroutineDispatcher by inject()

    private var currentPage = 1
    var uiState by mutableStateOf(HomeState())

    fun loadMovies(forceReload: Boolean) {
        if(uiState.loading) return
        if(forceReload) currentPage = 1
        if(currentPage == 1) uiState = uiState.copy(refreshing = true)

        viewModelScope.launch(dispatchers) {
            getMoviesUseCase(currentPage).collect {
                when (it) {
                    is DataState.Error -> {
                        uiState = uiState.copy(
                            loading = false,
                            refreshing = false,
                            errorMessage = it.exception.message,
                        )
                    }
                    is DataState.Loading -> {
                        uiState = uiState.copy(
                            loading = true,
                        )
                    }
                    is DataState.Success ->  {
                        val movies = if(currentPage == 1) it.data else uiState.movies + it.data

                        currentPage += 1

                        uiState = uiState.copy(
                            loading = false,
                            refreshing = false,
                            loadFinished = it.data.isEmpty(),
                            movies = movies,
                        )
                    }
                }
            }
        }
    }
}