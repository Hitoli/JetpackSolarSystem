package com.example.myapplication.FeedScreen.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.FeedScreen.model.Article
import com.example.myapplication.FeedScreen.usecase.IGetFeedDetailsUsecase
import com.example.myapplication.Utils.ViewStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedScreenViewModel @Inject constructor(val Usecase: IGetFeedDetailsUsecase): ViewModel() {

    private val _detailsofarticlespace: MutableState<ViewStates> = mutableStateOf(ViewStates.Loading)
    val detailsofarticlespace: State<ViewStates> = _detailsofarticlespace

    init {
        getallarticledetails()
    }
    fun getallarticledetails(){
        viewModelScope.launch {
            try{
                val articldetails = Usecase()
                _detailsofarticlespace.value = ViewStates.Success(articldetails.articles!!)
              //  Log.e("MEAl DETAILS",articldetails.articles?.get(0).toString())
                Log.e("_detailsofarticlespace _detailsofarticlespace",_detailsofarticlespace.toString())
            }catch (e:Exception){
                Log.e("Error articleviewmodel",e.message.toString())
                _detailsofarticlespace.value= ViewStates.Failure(e.message?:"Unknown Error Occured :(")
                //_listofDishes.value= DishesViewModel.ViewStates.Failure(e.message?:"Unknown Error Occured :(")
            }

        }
    }


}