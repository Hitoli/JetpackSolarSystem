package com.example.myapplication.FeedScreen.repository

import android.util.Log
import com.example.myapplication.FeedScreen.model.SpaceResponse
import com.example.myapplication.FeedScreen.services.IGetFeedService
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

interface IGetFeedScreenRepo{
    suspend fun getallFeed():SpaceResponse
}

class FeedScreenRepository @Inject constructor(val services: IGetFeedService):IGetFeedScreenRepo{
    val yesterday = LocalDate.now().minusDays(1)
    val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val formattedDate = yesterday.format(dateFormat)


    override suspend fun getallFeed(): SpaceResponse {
        val response = services.getNewsArticles(from =formattedDate, to = formattedDate)
        Log.e("response",response.articles.toString())
        Log.e("date",formattedDate.toString())
      //  Log.e("date",dateFormatter.toString())
        return response
    }
}
