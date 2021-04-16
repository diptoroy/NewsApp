package com.ddev.newsapp.remote

import com.ddev.newsapp.model.currentsnews.News
import com.ddev.newsapp.model.newsorg.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
//    @GET("/v1/latest-news?language=it")
//    suspend fun getNews(
//        @Query("apiKey") apiKey: String
//    ): Response<News>

    @GET("v2/top-headlines?country=us")
    suspend fun getNews(
            @Query("apiKey") apiKey: String
    ): Response<NewsData>
}