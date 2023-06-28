
import Home.route
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.route.Route
import presentation.common.AgentAppBar
import presentation.navigation.NavGraph
import presentation.navigation.currentRoute

/**
 * created by Josue Lubaki
 * date : 2023-05-02
 * version : 1.0.0
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSetup(navigator: Navigator) {
    val currentRoute = navigator.currentRoute()

    Scaffold(
        topBar = {
            currentRoute.canShowingTopAppBar().takeIf { it }?.apply {
                AgentAppBar(
                    title = Home.title,
                    onNavigateBack = navigator::goBack,
                    iconVisible = navigator.currentRoute()?.route != route
                )
            }
        }
    ) { innerPaddings ->
        NavGraph(
            navigator = navigator,
            modifier = Modifier
                .padding(innerPaddings)
        )
    }
}

private fun Route?.canShowingTopAppBar(): Boolean {
    val routeToDisplay = listOf(Detail.routeWithArgs)
    return (routeToDisplay.contains(this?.route))
}
