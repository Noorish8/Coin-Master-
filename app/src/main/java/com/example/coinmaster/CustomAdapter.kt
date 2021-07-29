package com.example.coinmaster

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

//class CustomAdapter(val context: Context, val img1: ArrayList<DataModalcm>):BaseAdapter(){
//    private  val inflater: LayoutInflater
//            =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
//
//
//    override fun getCount(): Int {
//       return  img1.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return img1[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val rowView = inflater.inflate(R.layout.list1, parent, false)
//        val image: ImageView
//        val textView:TextView
//        image = rowView.findViewById(R.id.imgcm1)
//        textView =rowView.findViewById(R.id.textView6)
//
//        textView.text = img1.get(position).title
//        Glide.with(context)
//            .load(img1.get(position).img)
//            .into(image)
//
//
//        return rowView
//
//
//        Log.e("titile>>>>>",img1.get(position).title+"")
//
//    }
//
//}