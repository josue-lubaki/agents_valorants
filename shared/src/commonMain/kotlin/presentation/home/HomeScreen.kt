package presentation.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.Movie
import presentation.components.MovieListItem
import utils.Colors

/**
 * created by Josue Lubaki
 * date : 2023-04-30
 * version : 1.0.0
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    viewModel : HomeViewModel,
    modifier: Modifier = Modifier,
    navigateToDetails: (Movie) -> Unit,
) {

    val uiState = viewModel.uiState
    val loadNextMovies = {
        viewModel.loadMovies(forceReload = false)
    }

    LaunchedEffect(Unit) {
        viewModel.loadMovies(forceReload = false)
    }

    val pullRefreshState = rememberPullRefreshState(
        refreshing = uiState.refreshing,
        onRefresh = { loadNextMovies() }
    )

    val lazyState = rememberLazyGridState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.onBackground)
            .pullRefresh(state = pullRefreshState)
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = lazyState,
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            itemsIndexed(
                items = uiState.movies,
                key = { _, movie -> movie.id }
            ) { index, movie ->
                MovieListItem(
                    movie = movie,
                    onClick = { navigateToDetails(movie) },
                )

                if (
                    index >= uiState.movies.size - 1
                    && !uiState.loading
                    && !uiState.loadFinished
                ) {
                    LaunchedEffect(Unit) {
                        loadNextMovies()
                    }
                }
            }

            if(uiState.loading && uiState.movies.isNotEmpty()){
                item(span = { GridItemSpan(2) }){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        CircularProgressIndicator(
                            color = Colors.Red
                        )
                    }
                }
            }
        }

        PullRefreshIndicator(
            refreshing = uiState.refreshing,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
        )
    }
}