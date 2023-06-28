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

@Composable
fun Stars5(maxwidth: Dp, maxheight: Dp) {
    val StarSize = 50.dp
    val modifier: Modifier
    var moonAngle by remember { mutableStateOf(0f) }
    val infiniteTrans = rememberInfiniteTransition()
    val MoonsActivity = infiniteTrans.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 16000), repeatMode = RepeatMode.Reverse
        )
    )
    LaunchedEffect(Unit) {
        while (true) {
            moonAngle = MoonsActivity.value
            delay(1) // Increase the delay time to slow down the animation
        }
    }
    modifier = Modifier.offset(
        x = maxwidth * moonAngle,
        y = maxheight* moonAngle
    )
    Image(
        painter = painterResource(id = R.drawable.planet), contentDescription = "Star", modifier = modifier
            .width(StarSize)
            .height(StarSize), alpha = moonAngle
    )

}