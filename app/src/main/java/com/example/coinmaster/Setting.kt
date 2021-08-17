package com.example.coinmaster

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
            super.onBackPressed()
        }
        like.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.facebook.com/Spin-coin-Getter-free-spin-and-coin-104010491515465")
            startActivity(intent)
        }
        term.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://gamland.ga/Game_Land_with_saumin/GameLand_Other/Terms_&_Conditions")
            startActivity(intent)
        }
        rate.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://play.google.com/store/apps/details?id=com.free.spining.coins")
            startActivity(intent)
        }
        share.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://play.google.com/store/apps/details?id=com.free.spining.coins")
            startActivity(intent)
        }
        group.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://m.facebook.com/groups/coinmasterfreespinscoinmaster")
            startActivity(intent)
        }
        policy.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://gamland.ga/Game_Land_with_saumin/GameLand_Other/Privacy_Policy")
            startActivity(intent)
        }
    }
    }
//            fun getUrlFromIntent(view: View) {
//                val url =
//                    "https://www.facebook.com/Spin-coin-Getter-free-spin-and-coin-104010491515465"
//                val intent = Intent(Intent.ACTION_VIEW)
//                intent.data = Uri.parse(url)
//                startActivity(intent)
//
//            }

