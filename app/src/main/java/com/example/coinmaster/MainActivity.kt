package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView

    //lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image1)

        //progressBar=findViewById(R.id.splashProgress)
//        imageView.setOnClickListener {
            Handler().postDelayed({

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()

            }, 500L)


        }
    }
