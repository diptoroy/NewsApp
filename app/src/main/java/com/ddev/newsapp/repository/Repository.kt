package com.ddev.newsapp.repository

import com.ddev.newsapp.model.New
import com.ddev.newsapp.model.News
import com.ddev.newsapp.remote.NewsApiClient
import retrofit2.Response

class Repository {
    suspend fun getNews(apiKey: String): Response<News> {
        return NewsApiClient.news.getNews(apiKey)
    }
}