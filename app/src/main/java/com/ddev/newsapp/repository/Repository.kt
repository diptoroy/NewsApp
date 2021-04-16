package com.ddev.newsapp.repository

import com.ddev.newsapp.model.currentsnews.News
import com.ddev.newsapp.model.newsorg.NewsData
import com.ddev.newsapp.remote.NewsApiClient
import retrofit2.Response

class Repository {
    suspend fun getNews(apiKey: String): Response<NewsData> {
        return NewsApiClient.news.getNews(apiKey)
    }
}