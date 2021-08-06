package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Setting : AppCompatActivity() {
    lateinit var imageViewback: ImageView
    lateinit var like: ImageView
    lateinit var share: ImageView
    lateinit var term: ImageView
    lateinit var group: ImageView
    lateinit var rate: ImageView
    lateinit var policy: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        imageViewback = findViewById(R.id.back)
        like = findViewById(R.id.like)
        share = findViewById(R.id.share)
        term = findViewById(R.id.term)
        group = findViewById(R.id.group)
        rate = findViewById(R.id.rate)
        policy = findViewById(R.id.policy)

        imageViewback.setOnClickListener {
            val intent = Intent(this, CoinMaster::class.java)
            startActivity(intent)
        }
        fun onBackPressed() {
            val intent = Intent(this, CoinMaster::class.java)
            startActivity(intent)
        }
        like.setOnClickListener {

        }
    }
}
