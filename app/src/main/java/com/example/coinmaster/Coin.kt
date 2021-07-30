package com.example.coinmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Coin : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var coinAdapter: CoinAdapter
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


        val stringRequest: StringRequest =object : StringRequest(Method.POST,url, Response.Listener {
                response ->
            Log.i("respons>>>>>>",response+"")
            Toast.makeText(this, response, Toast.LENGTH_LONG).show()
            val jsonObject: JSONObject = JSONObject(response)
//           val status:String=jsonObject.getString("status")
//           val message:String=jsonObject.getString("message")
            val jsonArray: JSONArray =jsonObject.getJSONArray("data")
            for(i in 0 until jsonArray.length()){
                val jsonObject1: JSONObject =jsonArray.getJSONObject(i)
                val title:String=jsonObject1.getString("title")
                val image: String = "https://gamland.ga/Game_Land_with_saumin/"+jsonObject1.getString("image")
                val dataModal=DataModalcoin()
                dataModal.img=image
                dataModal.title=title
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
                params["game_category"]="coinsspin"
                return params
            }
        }
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}