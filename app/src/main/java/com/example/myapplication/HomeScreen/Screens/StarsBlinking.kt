
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun StarsBlinking(maxwidth: Dp, maxheight: Dp) {
    val starSize = 10.dp
    val modifier: Modifier
   // var moonAngle by remember { mutableStateOf(0f) }
    val infiniteTrans = rememberInfiniteTransition()
    val moonsActivity = infiniteTrans.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    var offsetX by remember { mutableStateOf(maxwidth) }
    var offsetY by remember { mutableStateOf(maxheight) }
    LaunchedEffect(Unit) {
        while (true) {
            offsetX = Dp((1f + Random.nextFloat() * (maxwidth.value - 1)).toFloat())
            offsetY = Dp((1f + Random.nextFloat() * (maxheight.value - 1)).toFloat())
            delay(2000) // Increase the delay time to slow down the animation
        }
    }
    modifier = Modifier.offset(x = offsetX, y = offsetY)
    Image(
        painter = painterResource(id = R.drawable.planet),
        contentDescription = "Star",
        modifier = modifier.width(starSize).height(starSize),
        alpha = moonsActivity.value
    )
}

@Composable
fun StarsBlinking2(maxwidth: Dp, maxheight: Dp) {
    val starSize = 10.dp
    val modifier: Modifier
    // var moonAngle by remember { mutableStateOf(0f) }
    val infiniteTrans = rememberInfiniteTransition()
    val moonsActivity = infiniteTrans.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    var offsetX by remember { mutableStateOf(maxwidth) }
    var offsetY by remember { mutableStateOf(maxheight) }
    LaunchedEffect(Unit) {
        while (true) {
            offsetX = Dp((1f + Random.nextFloat() * (maxwidth.value - 1)).toFloat())
            offsetY = Dp((1f + Random.nextFloat() * (maxheight.value - 1)).toFloat())
            delay(2000) // Increase the delay time to slow down the animation
        }
    }
    modifier = Modifier.offset(x = offsetX, y = offsetY)
    Image(
        painter = painterResource(id = R.drawable.planet),
        contentDescription = "Star",
        modifier = modifier.width(starSize).height(starSize),
        alpha = moonsActivity.value
    )
}

