package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Guide : AppCompatActivity() {
    lateinit var imageViewback: ImageView
    lateinit var imageViewyellow: ImageView
    lateinit var imageViewciyan: ImageView
    lateinit var imageViewred: ImageView
    lateinit var imageViewperpol: ImageView
    lateinit var imageVieworange: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        imageViewyellow=findViewById(R.id.imageViewyellow)
        imageViewciyan=findViewById(R.id.imageViewciyan)
        imageViewred=findViewById(R.id.imageViewred)
        imageViewperpol=findViewById(R.id.imageViewperpol)
        imageVieworange=findViewById(R.id.imageVieworange)
        //setContentView(R.layout.activity_guide)
        imageViewback=findViewById(R.id.back)
        imageViewback.setOnClickListener {
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        imageViewyellow.setOnClickListener {
            val intent=Intent(this,playitdaily::class.java)
            startActivity(intent)
        }
        imageViewciyan.setOnClickListener {
            val intent=Intent(this,Learnslotmachine::class.java)
            startActivity(intent)
        }
            imageViewred.setOnClickListener {
                val intent=Intent(this,Finishallevents::class.java)
                startActivity(intent)
            }
        imageViewperpol.setOnClickListener {
            val intent=Intent(this,Concentrateoncoinsaccordingly::class.java)
            startActivity(intent)
        }
        imageVieworange.setOnClickListener {
            val intent=Intent(this,Collectyourcard::class.java)
            startActivity(intent)
        }
        fun onBackPressed() {
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }


    }
}