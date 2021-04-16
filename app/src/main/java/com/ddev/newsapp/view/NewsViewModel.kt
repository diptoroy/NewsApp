package com.ddev.newsapp.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ddev.newsapp.model.currentsnews.News
import com.ddev.newsapp.model.newsorg.NewsData
import com.ddev.newsapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(private val repository: Repository): ViewModel() {
    val newsresponse:MutableLiveData<Response<NewsData>> = MutableLiveData()

    fun getNews(apiKey: String){
        viewModelScope.launch {
            val news = repository.getNews(apiKey)
            newsresponse.value = news
        }
    }

}