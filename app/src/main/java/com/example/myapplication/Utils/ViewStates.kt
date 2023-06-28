package com.example.myapplication.Utils

import com.example.myapplication.FeedScreen.model.Article

sealed class ViewStates{
    object Loading:ViewStates()
    class Success(val data1: List<Article>) : ViewStates()
    class Failure(val data2:String):ViewStates()
}
