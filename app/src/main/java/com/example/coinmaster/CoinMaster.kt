package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class CoinMaster : AppCompatActivity() {
    private var backPressedTime:Long = 0

    lateinit var button25spin: Button
    lateinit var imageViewsetting: ImageView
    lateinit var imageViewback: ImageView
    lateinit var imageView2: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_master)
        imageViewsetting = findViewById(R.id.setting)
        imageViewback = findViewById(R.id.back)
        button25spin = findViewById(R.id.button25spin)
        button25spin.setOnClickListener {
            val intent = Intent(this, Collect::class.java)
            startActivity(intent)
        }

        //backToast = Toast.makeText(this, "Press back again to leave this page.", Toast.LENGTH_LONG)
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            // backToast.cancel()
            super.onBackPressed()
            return
//        } else {
//         backToast.show() //if you use fragment u should use getActivity().onBackPressed();  if you use single activity u can use
////        finish();
////
        }
        backPressedTime = System.currentTimeMillis()



        imageViewsetting.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
        }
        imageViewback.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }
        fun onBackPressed() {
         val intent=Intent(this,HomeActivity::class.java)
         startActivity(intent)
        }


    }
}