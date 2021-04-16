package com.ddev.newsapp.model.newsorg

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)