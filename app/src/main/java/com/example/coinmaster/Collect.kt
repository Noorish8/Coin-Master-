package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.bottomsheet.BottomSheetDialog

class Collect : AppCompatActivity() {
    lateinit var imageViewback: ImageView
    lateinit var buttonCollect: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collect)
        imageViewback=findViewById(R.id.back)
        imageViewback.setOnClickListener {
            val intent=Intent(this,CoinMaster::class.java)
        }
        buttonCollect = findViewById(R.id.btn)

        // adding on click listener for our button.
        buttonCollect.setOnClickListener {

            val btnsheet = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(btnsheet)
            btnsheet.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}