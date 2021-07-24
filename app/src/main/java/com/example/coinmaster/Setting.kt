package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Setting : AppCompatActivity() {
    lateinit var imageViewback: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        imageViewback=findViewById(R.id.back)
        imageViewback.setOnClickListener {
            val intent=Intent(this,CoinMaster::class.java)
            startActivity(intent)
        }
        fun onBackPressed() {
            val intent=Intent(this,CoinMaster::class.java)
            startActivity(intent)
        }
    }
}