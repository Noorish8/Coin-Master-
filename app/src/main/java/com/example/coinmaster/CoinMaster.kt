package com.example.coinmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class CoinMaster : AppCompatActivity() {
//    lateinit var imageViewapi: ImageView
//    lateinit var textViewapi: TextView
    val url:String="https://gamland.ga/Game_Land_with_saumin/api.php"
    val i:Int=0
    var list:ArrayList<DataModalcoin> = ArrayList<DataModalcoin>()
    //lateinit var listView: ListView
    private var backPressedTime:Long = 0

    //lateinit var button25spin: Button
    lateinit var imageViewsetting: ImageView
    lateinit var imageViewback: ImageView
    lateinit var imageView2: ImageView
    //lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_master)
        imageViewsetting = findViewById(R.id.setting)
        imageViewback = findViewById(R.id.back)
//        imageViewapi = findViewById(R.id.api1)
//        textViewapi = findViewById(R.id.apitx)
        //listView=findViewById(R.id.list)

//        button25spin = findViewById(R.id.button25spin)
//        button25spin.setOnClickListener {
//            val intent = Intent(this, Collect::class.java)
//            startActivity(intent)
//        }
        //list=ArrayList<DataModalcm>()
       val stringRequest:StringRequest=object :StringRequest(Method.POST,url,Response.Listener {
           response ->
           Log.i("respons>>>>>>",response+"")
           Toast.makeText(this, response, Toast.LENGTH_LONG).show()
           val jsonObject:JSONObject= JSONObject(response)
//           val status:String=jsonObject.getString("status")
//           val message:String=jsonObject.getString("message")
           val jsonArray: JSONArray =jsonObject.getJSONArray("data")
           for(i in 0 until jsonArray.length()){
               val jsonObject1:JSONObject=jsonArray.getJSONObject(i)
               val title:String=jsonObject1.getString("title")
               val dt:String=jsonObject1.getString("dt")
               val image: String = "https://gamland.ga/Game_Land_with_saumin/"+jsonObject1.getString("image")
               val dataModal=DataModalcoin()
               dataModal.img=image
               dataModal.title=title
               dataModal.dt=dt
               list.add(dataModal)

           }
//           Glide.with(this)
//               .load(list.get(0).img)
//               .into(imageViewapi)

           Log.e("title>>>>>", title as String)
//           customAdapter = CustomAdapter(this,list)
//           listView.adapter = customAdapter
       },
           Response.ErrorListener { error ->
               Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
       }) {
           override fun getParams(): Map<String, String> {
               val params: MutableMap<String, String> = HashMap()
               //Change with your post params
               params["f"] = "gameCategory"
               params["game"] = "coin master"
               return params
           }
       }
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)




        //backToast = Toast.makeText(this, "Press back again to leave this page.", Toast.LENGTH_LONG)
//        if (backPressedTime + 2000 > System.currentTimeMillis()) {
//            // backToast.cancel()
//            super.onBackPressed()
//            return
////        } else {
////         backToast.show() //if you use fragment u should use getActivity().onBackPressed();  if you use single activity u can use
//////        finish();
//////
//        }
//        backPressedTime = System.currentTimeMillis()
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