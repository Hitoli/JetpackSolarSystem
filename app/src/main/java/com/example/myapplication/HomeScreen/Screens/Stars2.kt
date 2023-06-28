package com.example.myapplication.HomeScreen.Screens

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
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Stars2(maxwidth: Dp, maxheight: Dp) {
    val StarSize = 30.dp
    val modifier: Modifier
    var moonAngle by remember { mutableStateOf(0f) }
    val infiniteTrans = rememberInfiniteTransition()
    val MoonsActivity = infiniteTrans.animateFloat(
        initialValue = 0f,
        targetValue = 2 * Math.PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 10000), repeatMode = RepeatMode.Reverse
        )
    )
    LaunchedEffect(Unit) {
        while (true) {
            moonAngle = MoonsActivity.value
            delay(1) // Increase the delay time to slow down the animation
        }
    }
    val radius = .9f
    modifier = Modifier.offset(
        x =(maxwidth) * (radius * cos(moonAngle)),
        y =(maxheight)* (radius * sin(moonAngle))
    )
    Image(
        painter = painterResource(id = R.drawable.planet), contentDescription = "Star", modifier = modifier
            .width(StarSize)
            .height(StarSize), alpha = moonAngle/4
    )

}