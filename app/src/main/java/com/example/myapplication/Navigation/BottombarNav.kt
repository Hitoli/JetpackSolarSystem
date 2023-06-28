package com.example.myapplication.Navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myapplication.R

sealed class BottombarNav(
    var route:String,
    var title:String,
    @DrawableRes val icon: Int
){
    object Homescreen: BottombarNav(
        route = "Home",
        title = "Home",
        icon = R.drawable.milkywat
    )
    object PlanetScreen: BottombarNav(
        route = "Planets",
        title = "Planets",
        icon = R.drawable.star
    )
    object FeedScreen: BottombarNav(
        route = "Feed",
        title = "Feed",
        icon = R.drawable.news
    )
}
