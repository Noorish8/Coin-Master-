package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.json.JSONArray
import org.json.JSONObject

class Coinmaster1 : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var textViewdescription: TextView
    lateinit var imageViewcollect: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coinmaster1)
        imageViewcollect=findViewById(R.id.collect)
        imageViewcollect.setOnClickListener {

            val modalSheetView = layoutInflater.inflate(R.layout.bottom_sheet_dialog,null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(modalSheetView)
            dialog.show()

        }



    textView=findViewById(R.id.textlink)
    textViewdescription=findViewById(R.id.textdescription)

        val data: String? =intent.getStringExtra("link")
        val description:String?=intent.getStringExtra("description")

        Log.e("data>>>>",data+"")

    textView.text=data
  textViewdescription.text=description



    }
}