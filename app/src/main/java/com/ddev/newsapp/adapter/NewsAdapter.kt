package com.ddev.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddev.newsapp.R
import com.ddev.newsapp.model.New
import com.ddev.newsapp.model.News
import kotlinx.android.synthetic.main.news_row.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var newsList = emptyList<New>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.news_title.text = newsList[position].title
        holder.itemView.news_author.text = newsList[position].author
//        holder.itemView.acotrName.text = [position].actorDetails?.get(position)?.actorName
//        com.bumptech.glide.Glide.with(holder.itemView.context).load([position].actorDetails?.get(position)?.actorImage).into(holder.itemView.actorImage)
//
//        holder.itemView.setOnClickListener{
//            val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
//            intent.putExtra("title",[position].title)
//            intent.putExtra("director",[position].director)
//            holder.itemView.context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setData(newList: List<New>){
        notifyDataSetChanged()
        newsList = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}