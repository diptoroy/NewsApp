package com.ddev.newsapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddev.newsapp.model.New
import com.ddev.newsapp.model.News
import com.ddev.newsapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val repository: Repository): ViewModel() {
    val newsresponse:MutableLiveData<Response<News>> = MutableLiveData()

    fun getNews(apiKey: String){
        viewModelScope.launch {
            val news = repository.getNews(apiKey)
            newsresponse.value = news
        }
    }

}