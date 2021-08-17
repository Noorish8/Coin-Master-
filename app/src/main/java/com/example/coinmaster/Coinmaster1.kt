package com.example.coinmaster

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_faceboobadsb.*
import org.json.JSONArray
import org.json.JSONObject
class Coinmaster1 : AppCompatActivity() {
    lateinit var adView: AdView
    lateinit var textViewlink: TextView
    lateinit var textViewdescription: TextView
    lateinit var imageViewcollect: ImageView
    lateinit var textViewdt: TextView
   lateinit var back:ImageView
   lateinit var setting:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coinmaster1)

        setting=findViewById(R.id.setting)
        setting.setOnClickListener {
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
        }
        imageViewcollect=findViewById(R.id.collect)
        textViewlink=findViewById(R.id.textlink)
        textViewdescription=findViewById(R.id.textdescription)
        textViewdt=findViewById(R.id.textdt)

        back=findViewById(R.id.back)

        back.setOnClickListener {
            onBackPressed()
        }

        val data: String? =intent.getStringExtra("link")
        val description:String?=intent.getStringExtra("description")
        val dt:String?=intent.getStringExtra("dt")


        Log.e("dt>>>>",dt+"")

        textViewlink.text=data
        textViewdescription.text=description
        textViewdt.text=dt
        imageViewcollect.setOnClickListener {

            val modalSheetView = layoutInflater.inflate(R.layout.bottom_sheet_dialog,null)
            val dialog = BottomSheetDialog(this)

            val textViewredeem:TextView=modalSheetView.findViewById(R.id.Redeem)
            val textViewlink:TextView=modalSheetView.findViewById(R.id.Share)
            val textViewCencel:TextView=modalSheetView.findViewById(R.id.Cencel)
            val textViewCopy:TextView=modalSheetView.findViewById(R.id.Copy)

            textViewCencel.setOnClickListener {
                dialog.dismiss()
            }
            textViewlink.setOnClickListener {

                val sentIntent:Intent=Intent()
                sentIntent.setAction(Intent.ACTION_SEND)
                sentIntent.putExtra(Intent.EXTRA_TEXT, data)
                sentIntent.setType("text/plain")
                val shredIntent:Intent=Intent.createChooser(sentIntent, null)
                startActivity(shredIntent)
                Toast.makeText(this,"share the link",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            textViewCopy.setOnClickListener {
                lateinit var clipboardManager: ClipboardManager
                    clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clipData = ClipData.newPlainText("key", data)
                    clipboardManager.setPrimaryClip(clipData)
                Toast.makeText(this,"copy the link",Toast.LENGTH_SHORT).show()
                dialog.dismiss()

                }

            //click example for copy, share

            textViewredeem.setOnClickListener {
                dialog.dismiss()
                Toast.makeText(this,"reedem",Toast.LENGTH_SHORT).show()
            }
            dialog.setContentView(modalSheetView)
            dialog.show()

            }
        adView= AdView(this,"IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50)
        banner_container.addView(adView)//add pluging id 'kotlin-android-extensions'
        adView.loadAd()
    }

    override fun onDestroy() {
        if (adView != null){
            adView.destroy()
        }
        super.onDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    }
