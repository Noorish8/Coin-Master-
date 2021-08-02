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

class Spin : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adaptercoinandspin: Adaptercoinandspin
    val url: String = "https://gamland.ga/Game_Land_with_saumin/api.php"
    val i: Int = 0
    var list: ArrayList<DataModalcoinandspin> = ArrayList<DataModalcoinandspin>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.spin)
        recyclerView = findViewById(R.id.recycoin)



        val stringRequest: StringRequest =
            object : StringRequest(
                Method.POST, url, Response.Listener { response ->
                Log.i("respons>>>>>>", response + "")
                Toast.makeText(this, response, Toast.LENGTH_LONG).show()
                val jsonObject: JSONObject = JSONObject(response)
//           val status:String=jsonObject.getString("status")
//           val message:String=jsonObject.getString("message")
                val jsonArray: JSONArray = jsonObject.getJSONArray("data")
                for (i in 0 until jsonArray.length()) {
                    val jsonObject1: JSONObject = jsonArray.getJSONObject(i)
                    val game: String = jsonObject1.getString("game")
                    //val img: String = jsonObject1.getString("img")
                    val my_img: String = "https://gamland.ga/Game_Land_with_saumin/" + jsonObject1.getString("my_img")
                    val dataModal = DataModalcoinandspin()
                    dataModal.my_img = my_img
                   // dataModal.game = game
                    list.add(dataModal)
                }
                adaptercoinandspin= Adaptercoinandspin(this, list)
                val layoutManager = LinearLayoutManager(this)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adaptercoinandspin
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