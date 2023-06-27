
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.rememberNavigator
import presentation.AgentListScreen
import presentation.AgentListScreenViewModel

@Composable
internal fun App() {
    val navigator = rememberNavigator()
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AgentListScreen(viewModel = AgentListScreenViewModel())
        }
    }
}