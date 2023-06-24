
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.Navigator
import presentation.common.MovieAppBar
import presentation.navigation.NavGraph
import presentation.navigation.currentRoute

/**
 * created by Josue Lubaki
 * date : 2023-05-02
 * version : 1.0.0
 */

@Composable
fun MovieSetup(navigator: Navigator) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieAppBar(
                title = Home.title,
                onNavigateBack = {
                    navigator.goBack()
                },
                iconVisible = navigator.currentRoute()?.route != Home.route
            )
        }
    ) { innerPaddings ->
        NavGraph(
            navigator = navigator,
            modifier = Modifier.padding(innerPaddings)
        )
    }
}