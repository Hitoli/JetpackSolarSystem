package com.example.myapplication

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun planetanimation(maxwidth: Dp, maxheight: Dp) {

    val planetSize = 150.dp
    val modifier: Modifier
    var angle by remember { mutableStateOf(0f) }

    val infiniteTrans = rememberInfiniteTransition()
    val planetsactivity = infiniteTrans.animateFloat(
        initialValue = 0f,
        targetValue = 1 * 2f * Math.PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 8000), repeatMode = RepeatMode.Restart
    )
    )

    LaunchedEffect(Unit) {
        while (true) {
            angle = planetsactivity.value
            delay(1) // Increase the delay time to slow down the animation
        }
    }


    val radius = .2f
    modifier = Modifier.offset(
        x =(maxwidth/2) + (maxwidth / 2) * (radius * cos(angle))*2-30.dp,
        y =(maxheight/2) + (maxheight / 2)* (radius * sin(angle))/20- (planetSize / 4)
    )



    Image(
        painter = painterResource(id = R.drawable.planet), contentDescription = "Planet", modifier = modifier
            .width(planetSize)
            .height(planetSize), alpha = 0.9F
    )



}


@Composable
fun Sunplanet() {
    Image(painter = painterResource(id = R.drawable.planet), contentDescription ="Sun")
}


