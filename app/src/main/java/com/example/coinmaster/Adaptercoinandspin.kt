package com.example.coinmaster

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adaptercoinandspin
    (val context: Context,val list: List<DataModalcoin>):
    RecyclerView.Adapter<CoinAdapter.ViewHolder>() {
    private val inflater:LayoutInflater=
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textView1: TextView = view.findViewById(R.id.text1)
        val image: ImageView = view.findViewById(R.id.image1)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinAdapter.ViewHolder {
        val rowView = inflater.inflate(R.layout.coinandspinlist, parent, false)
        return CoinAdapter.ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: CoinAdapter.ViewHolder, position: Int) {
        holder.textView1.text = list.get(position).img
        Glide.with(context)
            .load(list.get(position).img)
            .into(holder.image)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}



