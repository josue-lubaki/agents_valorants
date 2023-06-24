import androidx.compose.ui.window.ComposeUIViewController
import com.myapplication.BuildKonfig
import moe.tlaster.precompose.PreComposeApplication

actual fun getPlatformName(): String = BuildKonfig.BASE_URL

fun MainViewController() = PreComposeApplication(title = "") { App() }