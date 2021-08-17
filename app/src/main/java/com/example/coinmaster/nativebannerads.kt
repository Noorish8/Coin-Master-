package com.example.coinmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.facebook.ads.*
import com.facebook.ads.NativeAdListener as NativeAdListener1


class nativebannerads : AppCompatActivity() {
    private val nativeAdLayout: NativeAdLayout? = null
    private val adView: LinearLayout? = null
    private var nativeBannerAd: NativeBannerAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nativebannerads)
//        val adLoader = AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
//            .forUnifiedNativeAd { unifiedNativeAd : UnifiedNativeAd ->
//                // Show the ad.
//
//                val adView = layoutInflater
//                    .inflate(R.layout.ad_unified, null) as UnifiedNativeAdView
//                populateUnifiedNativeAdView(unifiedNativeAd, adView)
//                if (isDestroyed) {
//                    unifiedNativeAd.destroy()
//                    return@forUnifiedNativeAd
//                }
//
//            }
//            .withAdListener(object : AdListener() {
//                override fun onAdFailedToLoad(errorCode: Int) {
//                    // Handle the failure by logging, altering the UI, and so on.
//                }
//            })
//            .withNativeAdOptions(NativeAdOptions.Builder()
//                // Methods in the NativeAdOptions.Builder class can be
//                // used here to specify individual options settings.
//                .build())
//            .build()
////        AudienceNetworkAds.initialize(this)
////
////        nativeBannerAd = NativeBannerAd(this, "YOUR_PLACEMENT_ID")
//       // val nativeAdListener=com.facebook.ads.NativeAdListener
//        //val nativeAdListener:com.facebook.ads.NativeAdListener=com.facebook.ads.NativeAdListener


    }
}