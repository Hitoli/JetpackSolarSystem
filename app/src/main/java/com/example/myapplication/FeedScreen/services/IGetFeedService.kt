package com.example.myapplication.FeedScreen.services

import com.example.myapplication.FeedScreen.model.SpaceResponse
import retrofit2.http.GET
import retrofit2.http.Query
//https://newsapi.org/v2/everything?q=space&from=2023-06-26&to=2023-06-26&sortBy=popularity&apiKey=485f2c68f02244d3bbddded2ced89b5f
//https://newsapi.org/v2/everything?q=space&from=2023-06-23&to=2023-06-23&sortBy=popularity&apiKey=485f2c68f02244d3bbddded2ced89b5f
interface IGetFeedService {
    @GET("everything")
    suspend fun getNewsArticles(
        @Query("q") q: String = "Solar+system",
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = "485f2c68f02244d3bbddded2ced89b5f"
    ): SpaceResponse
}

