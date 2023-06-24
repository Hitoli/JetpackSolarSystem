package com.example.myapplication.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottombarNav(
    var route:String,
    var title:String,
    var icon:ImageVector
){
    object Homescreen: BottombarNav(
        route = "Home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object PlanetScreen: BottombarNav(
        route = "Planet",
        title = "Planet",
        icon = Icons.Rounded.Star
    )
    object FeedScreen: BottombarNav(
        route = "Feed",
        title = "Feed",
        icon = Icons.Default.List
    )
}
