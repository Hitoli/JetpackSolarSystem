package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen() {
    Thesun()
}


@Composable
fun Thesun() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ) {
        Sunplanet()
        solarsystem()

    }
}

@Composable
fun solarsystem() {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        planetanimation(maxheight = maxHeight, maxwidth = maxWidth)
        planetanimation2(maxwidth = maxWidth, maxheight = maxHeight)
        planetanimation3(maxwidth = maxWidth, maxheight = maxHeight)
        planetanimation4(maxwidth = maxWidth, maxheight = maxHeight)
        planetanimation5(maxwidth = maxWidth, maxheight = maxHeight)

    }
}