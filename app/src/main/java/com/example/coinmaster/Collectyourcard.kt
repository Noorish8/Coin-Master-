package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Collectyourcard : AppCompatActivity() {
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collectyourcard)
        imageView = findViewById(R.id.back)
        imageView.setOnClickListener {
            val intent = Intent(this, Guide::class.java)
            startActivity(intent)
        }
        fun onBackPressed() {
            val intent = Intent(this, Guide::class.java)
            startActivity(intent)
        }
    }
}