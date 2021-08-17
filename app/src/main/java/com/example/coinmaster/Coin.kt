package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import kotlinx.android.synthetic.main.activity_faceboobadsb.*
import org.json.JSONArray
import org.json.JSONObject

class Coin : AppCompatActivity() {
    lateinit var adView: AdView

    lateinit var recyclerView: RecyclerView
    lateinit var coinAdapter: CoinAdapter
    lateinit var back:ImageView
//    lateinit var imageViewapi: ImageView
//    lateinit var textViewapi: TextView
    val url:String="https://gamland.ga/Game_Land_with_saumin/api.php"
    val i:Int=0
    var list:ArrayList<DataModalcoin> = ArrayList<DataModalcoin>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)
//        imageViewapi = findViewById(R.id.api1)
//        textViewapi = findViewById(R.id.apitx)
        recyclerView=findViewById(R.id.recycoin)
        back=findViewById(R.id.back)
        back.setOnClickListener {
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

        val data: String? =intent.getStringExtra(Constant.INTENT_TAG_COINS)

        Log.e("data>>>>",data+"")


        val stringRequest: StringRequest =object : StringRequest(Method.POST,url, Response.Listener {
                response ->
            Log.i("respons>>>>>>",response+"")

            val jsonObject: JSONObject = JSONObject(response)
           val status:String=jsonObject.getString("status")
           val message:String=jsonObject.getString("message")
            val jsonArray: JSONArray =jsonObject.getJSONArray("data")

            for(i in 0 until jsonArray.length()){
                val jsonObject1: JSONObject =jsonArray.getJSONObject(i)
                val title:String=jsonObject1.getString("title")
                val dt:String=jsonObject1.getString("dt")
                val game:String=jsonObject1.getString("game")
                val my_img:String=jsonObject1.getString("my_img")
                val description:String=jsonObject1.getString("description")
                val link:String=jsonObject1.getString("link")
                val image: String = "https://gamland.ga/Game_Land_with_saumin/"+jsonObject1.getString("my_img")
                val dataModal=DataModalcoin()
                dataModal.img=image
                dataModal.title=title
                dataModal.dt=dt
                dataModal.status=status
                dataModal.message=message
                dataModal.game=game
                dataModal.description=description
                dataModal.link=link
                dataModal.my_img=my_img
                list.add(dataModal)
            }
            coinAdapter=CoinAdapter(this,list)
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager=layoutManager
            recyclerView.adapter=coinAdapter



//            Glide.with(this)
//                .load(list.get(0).img)
//                .into(imageViewapi)

        },
            Response.ErrorListener { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                //Change with your post params
                params["f"] = "gameCategoryReward"
                params["game"] = "Coin master"
                params["game_category"]=data+""
                return params
            }
        }
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
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
}