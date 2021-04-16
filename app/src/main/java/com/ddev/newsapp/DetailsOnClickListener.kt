package com.ddev.newsapp

import com.ddev.newsapp.model.newsorg.Article

interface DetailsOnClickListener {
    fun onClick(item: Article, position: Int)
}