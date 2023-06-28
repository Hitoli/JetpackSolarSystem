package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.myapplication.ui.theme.nexaheavyfont
import java.net.URL

@Composable
fun FeedScreen(viewmodel:FeedScreenViewModel= hiltViewModel()) {

    Text(text = "FeedScreen Details")


    val articledetails by remember {
        viewmodel.detailsofarticlespace
    }
    
    LazyColumn{
        items(){

        }
    }

}

@Composable
fun SingleCategoryItem(Url:URL,content:String) {
    val paintit2 = Url
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
            .padding(0.dp)
            .background(color = Color.White, shape = RoundedCornerShape(20.dp)), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painter , contentDescription = null, modifier = Modifier.size(200.dp))
            Text(text = content, fontFamily = nexaheavyfont, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp))

            Log.e("paintit2",paintit2.toString())
            Log.e("paintit",painter.toString())
        }
    }


}