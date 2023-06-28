package com.example.myapplication.FeedScreen.usecase

import com.example.myapplication.FeedScreen.model.SpaceResponse
import com.example.myapplication.FeedScreen.repository.FeedScreenRepository
import com.example.myapplication.FeedScreen.repository.IGetFeedScreenRepo
import javax.inject.Inject

interface IGetFeedDetailsUsecase{
    suspend operator fun invoke():SpaceResponse
}

class SpaceResposeUsecase @Inject constructor(val repo:IGetFeedScreenRepo):IGetFeedDetailsUsecase{
    override suspend fun invoke(): SpaceResponse {
        return repo.getallFeed()
    }
}