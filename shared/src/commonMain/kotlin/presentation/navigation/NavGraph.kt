package presentation.navigation

import Detail
import Home
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.route.Route
import moe.tlaster.precompose.navigation.transition.NavTransition
import presentation.detail.DetailScreen
import presentation.detail.DetailViewModel
import presentation.home.AgentListScreen
import presentation.home.AgentListScreenViewModel

/**
 * created by Josue Lubaki
 * date : 2023-05-10
 * version : 1.0.0
 */

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navigator : Navigator
) {
    NavHost(
        navigator = navigator,
        initialRoute = Home.route,
        modifier = modifier
    ){
        scene(
            route = Home.route,
            navTransition = NavTransition(
                createTransition =
                    fadeIn(animationSpec = tween(600)),

                resumeTransition =
                   fadeIn(animationSpec = tween(600)),

               destroyTransition =
                   fadeOut(animationSpec = tween(600))
            )
        ) {
            AgentListScreen(
                viewModel = AgentListScreenViewModel(),
                onNavigateToDetail = { uuid ->
                    navigator.navigate("${Detail.route}/$uuid")
                }
            )
        }

        scene(
            route = Detail.routeWithArgs,
            navTransition = NavTransition(
                createTransition =
                    fadeIn(animationSpec = tween(600)),

                resumeTransition =
                    fadeIn(animationSpec = tween(600)),

                destroyTransition =
                    fadeOut(animationSpec = tween(600))
            )
        ) {
            val agentUuid: String = it.path<String>(Detail.argsName) ?: ""
            val detailViewModel = DetailViewModel()
            DetailScreen(
                viewModel = detailViewModel,
                agentUuid = agentUuid
            )
        }
    }
}

@Composable
fun Navigator.currentRoute(): Route? {
    return currentEntry.collectAsState(null).value?.route
}