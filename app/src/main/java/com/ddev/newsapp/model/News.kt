package com.ddev.newsapp.model

data class News(
    val news: List<New>,
    val page: Int,
    val status: String
)