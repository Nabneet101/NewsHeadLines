package com.example.newsshare

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.newsfresh.News
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class MainActivity : AppCompatActivity(), NewsItemClicked {

    companion object{
        const val NAME_CONSTANT="url"
    }
    private lateinit var mAdapter: NewsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager=LinearLayoutManager(this)
        var url=intent.getStringExtra(NAME_CONSTANT).toString()
        fetchData(url)
            mAdapter= NewsListAdapter(this)
        recyclerView.adapter=mAdapter


        progressBar.visibility=View.INVISIBLE
    }
    private fun fetchData(url:String)
    {

     val url= url
        val jsonObjectRequest= JsonObjectRequest(
            Request.Method.GET,url
        ,null,
            Response.Listener {
                val newsJsonArray=it.getJSONArray("articles")
                val newsArray=ArrayList<News>()
                for (i in 0 until newsJsonArray.length())
                {
                    val newsJsonObject=newsJsonArray.getJSONObject(i)
                    val news= News(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }
            mAdapter.updateNews(newsArray)
            },

            Response.ErrorListener {
                Toast.makeText(this,"Check Your Network Connection",Toast.LENGTH_LONG).show()
                progressBar.visibility=View.VISIBLE
            }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }


    override fun onItemClicked(item: News) {
        val builder = CustomTabsIntent.Builder();
        val customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(item.url));
    }


}