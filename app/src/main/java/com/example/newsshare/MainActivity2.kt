package com.example.newsshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()
    scienceView.setOnClickListener()
    {
        val intent=Intent(this,MainActivity::class.java)
            val murl="https://saurav.tech/NewsAPI/top-headlines/category/science/in.json"
            intent.putExtra(MainActivity.NAME_CONSTANT,murl)
        startActivity(intent)
    }
       healthView.setOnClickListener()
        {
            val intent=Intent(this,MainActivity::class.java)
            val murl="https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
            intent.putExtra(MainActivity.NAME_CONSTANT,murl)
            startActivity(intent)
        }
       techView.setOnClickListener()
        {
            val intent=Intent(this,MainActivity::class.java)
            val murl="https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json"
            intent.putExtra(MainActivity.NAME_CONSTANT,murl)
            startActivity(intent)
        }
        SportsView.setOnClickListener()
        {
            val intent=Intent(this,MainActivity::class.java)
            val murl="https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json"
            intent.putExtra(MainActivity.NAME_CONSTANT,murl)
            startActivity(intent)
        }
        generalView.setOnClickListener()
        {
            val intent=Intent(this,MainActivity::class.java)
            val murl="https://saurav.tech/NewsAPI/top-headlines/category/general/in.json"
            intent.putExtra(MainActivity.NAME_CONSTANT,murl)
            startActivity(intent)
        }
       BusinessView.setOnClickListener()
        {
            val intent=Intent(this,MainActivity::class.java)
            val murl="https://saurav.tech/NewsAPI/top-headlines/category/business/in.json"
            intent.putExtra(MainActivity.NAME_CONSTANT,murl)
            startActivity(intent)
        }
        EntertainmentView.setOnClickListener()
        {
            val intent=Intent(this,MainActivity::class.java)
            val murl="https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json"
            intent.putExtra(MainActivity.NAME_CONSTANT,murl)
            startActivity(intent)
        }

    }
}

