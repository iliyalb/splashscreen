import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.singleWindowApplication
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    var r by remember { mutableStateOf(0) }
    var g by remember { mutableStateOf(0) }
    var b by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (r < 31 || g < 131 || b < 201) {
            if (r < 31) r += 1
            if (g < 131) g += 2
            if (b < 201) b += 5
            delay(50)
        }
        delay(500)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(r, g, b)),
        contentAlignment = Alignment.Center
    ) {
        Text("Loading...", color = Color.White)
    }
}

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text("Welcome to the Main Screen!", color = Color.Black)
    }
}

@Preview
@Composable
fun App() {
    var showSplash by remember { mutableStateOf(true) }

    if (showSplash) {
        SplashScreen { showSplash = false }
    } else {
        MainScreen()
    }
}

fun main() = singleWindowApplication(
    title = "SplashScreenApp"
) {
    App()
}
