package com.ddev.newsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.ddev.newsapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.details_news.*

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_news)

        val bundle:Bundle? = intent.extras
        if (bundle != null) {
            article_details_title.text = bundle!!.getString("title")
            article_details_date.text = bundle!!.getString("date")
            article_details_author.text = bundle!!.getString("author")
            article_details_source.text = bundle!!.getString("source")
            val all: String? = bundle!!.getString("description") +
                    bundle!!.getString("content") +
                    bundle!!.getString("description") +
                    bundle!!.getString("content") +
                    bundle!!.getString("description") +
                    bundle!!.getString("content") +
                    bundle!!.getString("description") +
                    bundle!!.getString("content")
            article_details_details.text = all
            Glide.with(this).load(bundle.getString("image")).into(articledetails_image);
        }
    }
}