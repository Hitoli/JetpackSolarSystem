package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.myapplication.FeedScreen.model.Article
import com.example.myapplication.FeedScreen.model.SpaceResponse
import com.example.myapplication.FeedScreen.viewmodel.FeedScreenViewModel
import com.example.myapplication.Utils.FailureScreen
import com.example.myapplication.Utils.LoadingScreen
import com.example.myapplication.Utils.ViewStates
import com.example.myapplication.ui.theme.backgroundnav
import com.example.myapplication.ui.theme.nexaheavyfont
import com.example.myapplication.ui.theme.nexalightfont
import java.net.URL

@Composable
fun FeedScreen(viewmodel:FeedScreenViewModel= hiltViewModel()) {

    val articledetails by remember {
        viewmodel.detailsofarticlespace
    }

    if(articledetails!=null){
        Log.e("articledetails",articledetails.toString())
    }

    when(val state = articledetails) {
        is ViewStates.Failure -> FailureScreen()
        is ViewStates.Loading -> LoadingScreen()
        is ViewStates.Success ->
            LazyColumn(modifier = Modifier.background(Color.White)){
                item { 
                    CategoryTitleSub(NameCategory = "Discover")
                }
                item {
                    LazyRow(){
                        items(state.data1){
                            Imagecard(paint =it.urlToImage!! , contentDescription = it.title!! , title =it.title )
                        }
                    }
                }
                items(state.data1){
                    SingleCategoryItem(articles = it)
                }
            }
    }
    


}

@Composable
fun Imagecard(paint: String, contentDescription:String, title:String, modifier: Modifier = Modifier){
    val paintit2 = paint
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(paintit2)
            .build()
    )

    Card(modifier= Modifier.fillMaxWidth(), shape = RoundedCornerShape(15.dp), elevation = 5.dp){
        Box(modifier = Modifier.height(200.dp)){
            Image(painter = painter , contentDescription = null, modifier = Modifier.size(400.dp), contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent, Color.Black
                        ),
                        startY = 300f
                    )
                ))
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp), contentAlignment = Alignment.BottomStart){
                Text(title, style = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun SingleCategoryItem(articles:Article) {
    val paintit2 = articles.urlToImage
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(paintit2)
            .build()
    )
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
         , elevation = 2.dp, shape = RoundedCornerShape(20.dp)
    ) {
        Column(modifier = Modifier
            .background(color = Color.White, shape = RoundedCornerShape(20.dp)), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painter , contentDescription = null, modifier = Modifier.size(400.dp), contentScale = ContentScale.Crop)
            Text(text = articles.title!!, fontFamily = nexaheavyfont, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(16.dp))
            Text(text = articles.description!!, fontFamily = nexalightfont, fontSize = 15.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(16.dp))

            Log.e("paintit2",paintit2.toString())
            Log.e("paintit",painter.toString())
        }
    }


}

@Composable
fun CategoryTitleSub(NameCategory:String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)
        .background(
            Color.Black,
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
        )
        .padding(30.dp), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = NameCategory, fontFamily = nexaheavyfont, fontSize = 30.sp, textAlign = TextAlign.Left, color = Color.White)
        //Spacer(modifier = Modifier.padding(8.dp))
       // Text(text = "Unveil the Universe", fontFamily = nexalightfont, fontSize = 24.sp, textAlign = TextAlign.Left, modifier = Modifier.padding(16.dp))

    }

}