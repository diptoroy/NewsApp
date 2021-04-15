package com.ddev.newsapp.remote

import com.ddev.newsapp.model.New
import com.ddev.newsapp.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/v1/latest-news?language=it")
    suspend fun getNews(
        @Query("apiKey") apiKey: String
    ): Response<News>
}