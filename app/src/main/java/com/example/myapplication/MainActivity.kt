package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Thesun()


        }
    }
}

    @Composable
    fun Thesun() {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.background(color = Color.Black).fillMaxSize()) {
            Sunplanet()
            solarsystem()
        }
    }

@Composable
fun solarsystem() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()
        ) {
        planetanimation(maxheight = maxHeight, maxwidth = maxWidth)
        planetanimation2(maxwidth = maxWidth, maxheight =maxHeight )
        planetanimation3(maxwidth = maxWidth, maxheight =maxHeight )
        planetanimation4(maxwidth = maxWidth, maxheight =maxHeight )
        planetanimation5(maxwidth = maxWidth, maxheight =maxHeight )
        // PlanetAnimation(maxwidth = maxWidth, maxheight = maxHeight)
    }




    //Column(modifier = Modifier.height(100.dp)) {

    //}
}
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}