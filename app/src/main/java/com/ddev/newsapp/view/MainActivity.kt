package com.ddev.newsapp.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.newsapp.Constants.Companion.API_KEY
import com.ddev.newsapp.DetailsOnClickListener
import com.ddev.newsapp.R
import com.ddev.newsapp.adapter.NewsAdapter
import com.ddev.newsapp.model.newsorg.Article
import com.ddev.newsapp.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity(),DetailsOnClickListener {

    private lateinit var viewModel: NewsViewModel
    private val newsAdapter by lazy { NewsAdapter(this) }

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
            shimmerFrameLayout.stopShimmer()
            shimmerFrameLayout.visibility = View.GONE
            newsRecyclerView.visibility = View.VISIBLE
            it.body()?.let { it1 -> newsAdapter.setData(it1.articles) }
            Log.d("news",it.body().toString())
        })

        setUpNews()
    }

    private fun setUpNews() {
        newsRecyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        newsRecyclerView.setHasFixedSize(true)
        newsRecyclerView.adapter = newsAdapter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(item: Article, position: Int) {
        val intent = Intent(this,NewsDetailsActivity::class.java)
        intent.putExtra("image",item.urlToImage)
        intent.putExtra("author",item.author)
        intent.putExtra("title",item.title)
        intent.putExtra("date",item.publishedAt)
        intent.putExtra("description",item.description)
        intent.putExtra("source",item.source.name)
        startActivity(intent)
    }
}