package com.ddev.newsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.newsapp.Constants.Companion.API_KEY
import com.ddev.newsapp.R
import com.ddev.newsapp.adapter.NewsAdapter
import com.ddev.newsapp.model.New
import com.ddev.newsapp.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsViewModel
    private val newsAdapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = NewsViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(NewsViewModel::class.java)

        viewModel.getNews(API_KEY)
        viewModel.newsresponse.observe(this, Observer {
//            for (article in it.news){
//                Log.d("news","$article")
//
//            }
            it.body()?.let { it1 -> newsAdapter.setData(it1.news) }
        })

        setUpNews()
    }

    private fun setUpNews() {
        newsRecyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        newsRecyclerView.setHasFixedSize(true)
        newsRecyclerView.adapter = newsAdapter
    }
}