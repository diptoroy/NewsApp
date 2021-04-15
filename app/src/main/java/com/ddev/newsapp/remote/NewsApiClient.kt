package com.ddev.newsapp.remote

import com.ddev.newsapp.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiClient {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val news: NewsApi  by lazy {
        retrofit.create(NewsApi::class.java)
    }
}