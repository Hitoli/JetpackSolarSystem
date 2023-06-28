package com.example.myapplication

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.myapplication.Navigation.BottombarNav
import com.example.myapplication.ui.theme.backgroundnav
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation() {
    val navController = rememberNavController()
    Scaffold(

        bottomBar = { BottomBar(navcontroller = navController)}
    ){
        BottombarNavGraph(navcontroller = navController)
    }
}

@Composable
fun BottomBar(navcontroller: NavHostController) {
    val Screens = listOf(
        BottombarNav.Homescreen,
        BottombarNav.FeedScreen,
        BottombarNav.PlanetScreen
    )

    val navbackstackEntry by navcontroller.currentBackStackEntryAsState()
    val currentdestination = navbackstackEntry?.destination

    BottomNavigation(modifier = Modifier
        .fillMaxWidth()
        .height(74.dp)
        .graphicsLayer {
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            clip = true
        }, backgroundColor = Color.White) {
        Screens.forEach{screens ->
            AddItem(screen = screens, currentdestination = currentdestination, navController =navcontroller )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottombarNav,
    currentdestination:NavDestination?,
    navController:NavHostController
) {
    BottomNavigationItem(modifier = Modifier, unselectedContentColor = Color.Black, selectedContentColor = Color.Transparent,
        label = {
            Text(text = screen.title)
        }, icon = {
            val icon = painterResource(screen.icon)
            Icon(painter = icon, contentDescription = screen.title,
            modifier = Modifier.size(25.dp))
           // Icon(imageVector = screen.icon, contentDescription =screen.title)
        }, selected = currentdestination?.hierarchy?.any{
            it.route==screen.route
        }==true,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}

@Composable
fun BottombarNavGraph(navcontroller:NavHostController){
    NavHost(navController = navcontroller,  startDestination = BottombarNav.Homescreen.route){
        composable(route = BottombarNav.Homescreen.route){
            HomeScreen()
        }
        composable(route = BottombarNav.FeedScreen.route){
            FeedScreen()
        }
        composable(route = BottombarNav.PlanetScreen.route){
            PlanetScreen()
        }
    }

}


