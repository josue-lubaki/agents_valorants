package presentation.navigation

import Detail
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.route.Route
import presentation.home.AgentListScreen
import presentation.home.AgentListScreenViewModel
import presentation.detail.DetailScreen
import presentation.detail.DetailViewModel

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
        scene(route = Home.route) {
            AgentListScreen(
                viewModel = AgentListScreenViewModel(),
                onNavigateToDetail = { uuid ->
                    navigator.navigate("${Detail.route}/$uuid")
                }
            )
//            val homeViewModel = HomeViewModel()
//            HomeScreen(
//                viewModel = homeViewModel,
//                navigateToDetails = { agent ->
//                    navigator.navigate("${Detail.route}/${agent.uuid}")
//                },
//            )
        }

        scene(route = Detail.routeWithArgs) {
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