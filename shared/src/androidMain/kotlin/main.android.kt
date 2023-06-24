import androidx.compose.runtime.Composable
import com.myapplication.BuildKonfig

actual fun getPlatformName(): String = BuildKonfig.BASE_URL

@Composable fun MainView() = App()
