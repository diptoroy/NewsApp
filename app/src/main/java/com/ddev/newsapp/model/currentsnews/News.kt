package com.ddev.newsapp.model.currentsnews

data class News(
        val news: List<New>,
        val page: Int,
        val status: String
)