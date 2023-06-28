package com.example.myapplication.di

import com.example.myapplication.FeedScreen.repository.FeedScreenRepository
import com.example.myapplication.FeedScreen.repository.IGetFeedScreenRepo
import com.example.myapplication.FeedScreen.services.IGetFeedService
import com.example.myapplication.FeedScreen.usecase.IGetFeedDetailsUsecase
import com.example.myapplication.FeedScreen.usecase.SpaceResposeUsecase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitResponse(): Retrofit {
        return Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideFeedService(retrofit: Retrofit): IGetFeedService {
        return retrofit.create(IGetFeedService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {


        @Binds
        @Singleton
        fun provideFeedScreenRepository(repo: FeedScreenRepository): IGetFeedScreenRepo

        @Binds
        @Singleton
        fun provideFeedScreenUsecase(uc: SpaceResposeUsecase): IGetFeedDetailsUsecase

    }
}