package com.example.coinmaster

//import com.android.volley.Request
//import com.android.volley.Response
//import com.android.volley.toolbox.StringRequest
//import com.android.volley.toolbox.Volley
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.facebook.ads.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class HomeActivity : AppCompatActivity() {

    val url:String="https://gamland.ga/Game_Land_with_saumin/api.php"
    val i:Int=0
    var list:ArrayList<DataModal> = ArrayList<DataModal>()
    private var interstitialAd: InterstitialAd? = null
    private val TAG: String = HomeActivity::class.java.getSimpleName()

    //val url:String="https://api.androidhive.info/volley/person_object.json"
    // private val adView: AdView? = null
//    private var interstitialAd: InterstitialAd?=null
//    private val TAG: String = HomeActivity::class.java.getSimpleName()
//    private var interstitialAd: InterstitialAd?=null
    lateinit var imageViewimage1: ImageView
    lateinit var imageViewlefttop: ImageView
    lateinit var imageViewleftbtm: ImageView
    lateinit var imageViewrighttop: ImageView
    lateinit var imageViewrightbtm: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        imageViewimage1 = findViewById(R.id.image1)
        imageViewlefttop = findViewById(R.id.Guide)
        //Glide.with(this).load("https://mrveep.com/upload/baby1.jpg").into(imageViewlefttop)
        imageViewleftbtm = findViewById(R.id.Coin)
        imageViewrighttop = findViewById(R.id.CoinandSpin)
        imageViewrightbtm = findViewById(R.id.Spin)

        list=ArrayList<DataModal>()
        val stringRequest: StringRequest = object : StringRequest(Method.POST, url,
            Response.Listener { response ->
                Log.e("respons>>>>>>",response+"")
                Toast.makeText(this, response, Toast.LENGTH_LONG).show()
                val jsonObject:JSONObject= JSONObject(response)
                val status:String=jsonObject.getString("status")
                val message:String=jsonObject.getString("message")
                val jsonArray: JSONArray =jsonObject.getJSONArray("data")
                for (i in 0 until jsonArray.length()) {
                    val jsonobject1: JSONObject = jsonArray.getJSONObject(i)
                    val game: String = jsonobject1.getString("game")

                    val img: String = "https://gamland.ga/Game_Land_with_saumin/"+jsonobject1.getString("img")
                    val dataModal=DataModal()
                    dataModal.status=status
                    dataModal.message=message
                    dataModal.game=game
                    dataModal.img=img
                   list.add(dataModal)


                    //val imageViewurl: String ="https://gamland.ga/Game_Land_with_saumin/"+object.getstring("image")
                }

                Glide.with(this)
                    .load(list.get(0).img)
                    .into(imageViewlefttop)

                Glide.with(this)
                    .load(list.get(1).img)
                    .into(imageViewimage1)

                Glide.with(this)
                    .load(list.get(2).img)
                    .into(imageViewrighttop)

                Glide.with(this)
                    .load(list.get(3).img)
                    .into(imageViewrightbtm)

                Glide.with(this)
                    .load(list.get(4).img)
                    .into(imageViewleftbtm)
//                try {
//                    val jsonObject:JSONObject= JSONObject(response)
//                    val result:String=jsonObject.getString("result")
//
//
//                    Glide.with(MainActivity.this)
//                        .load(jsonObject1.getString(""))
//                        .into()
//
//
//                    //Parse your api responce here
//                    /*val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)*/
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, error.toString(), Toast.LENGTH_LONG).show()
            }) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                //Change with your post params
                params["f"] = "game"
                params["game_category"] = "coin master"
                return params
            }
        }
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)


        imageViewrightbtm.setOnClickListener {
            val intent=Intent(this,Collect::class.java)
            startActivity(intent)
        }
        imageViewlefttop.setOnClickListener {
            val intent=Intent(this,Guide::class.java)
            startActivity(intent)
        }
        imageViewleftbtm.setOnClickListener {
            val intent=Intent(this,Coin::class.java)
            startActivity(intent)

        }
        imageViewrighttop.setOnClickListener {
            val intent=Intent(this,Coinandspin::class.java)
            startActivity(intent)

        }

//       val request:StringRequest= StringRequest(Request.Method.GET,url,Response.Listener {
//                response ->
//            Log.e("response>>>>>>",response)
//            val jsonObject:JSONObject= JSONObject(response)
//            val name :String=jsonObject.getString("name")
//            imageViewimage1.text=name

        imageViewimage1.setOnClickListener {

            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Ads is loading,please wait")
            progressDialog.show()

            //        interstitialAd = InterstitialAd(this, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID")
            AudienceNetworkAds.initialize(this)
            //  AudienceNetworkAds.initialize(this)
//         AdSettings.setIntegrationErrorMode(INTEGRATION_ERROR_CRASH_DEBUG_MODE);
            interstitialAd = InterstitialAd(this, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID")
            // Create listeners for the Interstitial Ad
            // Create listeners for the Interstitial Ad
            val interstitialAdListener: InterstitialAdListener = object : InterstitialAdListener {
                override fun onInterstitialDisplayed(ad: Ad) {
                    // Interstitial ad displayed callback
                    Log.e(TAG, "Interstitial ad displayed.")
                }

                override fun onInterstitialDismissed(ad: Ad) {
                    val intent = Intent(this@HomeActivity, CoinMaster::class.java)
                    startActivity(intent)
                    progressDialog.hide()
                    // Interstitial dismissed callback
                    val e = Log.e(TAG, "Interstitial ad dismissed.")

                }

                override fun onError(ad: Ad, adError: AdError) {
                    // Ad error callback
                    Log.e(TAG, "Interstitial ad failed to load: " + adError.errorMessage)
                }

                override fun onAdLoaded(ad: Ad) {
                    // Interstitial ad is loaded and ready to be displayed
                    Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!")
                    // Show the ad
                    interstitialAd!!.show()
                }

                override fun onAdClicked(ad: Ad) {
                    // Ad clicked callback
                    Log.d(TAG, "Interstitial ad clicked!")
                }

                override fun onLoggingImpression(ad: Ad) {
                    // Ad impression logged callback
                    Log.d(TAG, "Interstitial ad impression logged!")
                }
            }

            // For auto play video ads, it's recommended to load the ad
            // at least 30 seconds before it is shown

            // For auto play video ads, it's recommended to load the ad
            // at least 30 seconds before it is shown
            interstitialAd!!.loadAd(
                interstitialAd!!.buildLoadAdConfig()
                    .withAdListener(interstitialAdListener)
                    .build()

            )

        }
    }
//        imageViewlefttop.setOnClickListener {
////            val intent = Intent(this, MainActivity3::class.java)
////            startActivity(intent)
//
//        }
//        imageViewleftbtm.setOnClickListener {
////            val intent = Intent(this, MainActivity3::class.java)
////            startActivity(intent)
//
//        }
//        imageViewrighttop.setOnClickListener {
////            val intent = Intent(this, MainActivity3::class.java)
////            startActivity(intent)
//
//        }
//        imageViewrightbtm.setOnClickListener {
////            val intent = Intent(this, Spin::class.java)
////            startActivity(intent)

    override fun onBackPressed() {
//        val builder = AlertDialog.Builder(this)
//        builder.setMessage("You want to exit")
//        builder.setPositiveButton("yes", { dialogInterface: DialogInterface, i: Int ->
//            finish()
//        })
//        builder.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int ->
//            builder.show()
//        })


//        AlertDialog.Builder(this)
//
//            .setMessage("You want to exit")
//            .setCancelable(false)
//            .setPositiveButton("yes", object : DialogInterface.OnClickListener {
//                override fun onClick(dialog: DialogInterface?, which: Int) {
//                    // Whatever...
//                }
//            }).show()

    }
}