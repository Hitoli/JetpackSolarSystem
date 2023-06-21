package com.example.myapplication

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun planetanimation4(maxwidth: Dp, maxheight: Dp) {

    val context = LocalContext.current
    val displayMetrics = context.resources.displayMetrics
    val screenWidth = displayMetrics.widthPixels.toFloat()
    val screenHeight = displayMetrics.heightPixels.toFloat()

    val centerX = screenWidth/2
    val centerY = screenHeight/2
    //val resource: Painter
    val modifier: Modifier
    var angle by remember { mutableStateOf(0f) }
    val infiniteTrans = rememberInfiniteTransition()
    val planetsactivity = infiniteTrans.animateFloat(
        initialValue = 0f,
        targetValue = 4* 2f * Math.PI.toFloat(),
        animationSpec = infiniteRepeatable<Float>(
            animation = tween(durationMillis = 15000), repeatMode = RepeatMode.Restart
        )
    )
    LaunchedEffect(Unit) {
        while (true) {
            angle = planetsactivity.value
            delay(1) // Increase the delay time to slow down the animation
        }
    }



    val radius = .5f // Adjust the radius of the orbit


    modifier = Modifier.offset(
        x =(maxwidth/2) + (maxwidth / 2) * (radius * cos(angle))*2-50.dp,
        y =(maxheight/2) + (maxheight / 2)* (radius * sin(angle))/3-10.dp
    )

    //val calx = (maxwidth/2) * (radius * cos(angle))
    //val caly = (maxheight/2) * (radius * sin(angle))




    Image(
        painter = painterResource(id = R.drawable.planet), contentDescription = "Planet", modifier = modifier
            .width(90.dp)
            .height(90.dp), alpha = 0.6F
    )

}