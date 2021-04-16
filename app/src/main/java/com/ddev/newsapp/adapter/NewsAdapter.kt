package com.ddev.newsapp.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ddev.newsapp.DetailsOnClickListener
import com.ddev.newsapp.R
import com.ddev.newsapp.model.currentsnews.New
import com.ddev.newsapp.model.newsorg.Article
import kotlinx.android.synthetic.main.news_row.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class NewsAdapter(val detailsOnClickListener: DetailsOnClickListener) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var newsList = emptyList<Article>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_row,parent,false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.article_headline.text = newsList[position].title
        holder.itemView.article_author.text = newsList[position].author
        holder.itemView.article_date.text = newsList[position].publishedAt
        Glide.with(holder.itemView.context).load(newsList[position].urlToImage).into(holder.itemView.article_image)

        holder.itemView.setOnClickListener{
            detailsOnClickListener.onClick(newsList[position],position)
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setData(newList: List<Article>){
        notifyDataSetChanged()
        newsList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}