package com.example.coinmaster

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(val context: Context, val list: ArrayList<DataModal>):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView6: TextView = view.findViewById(R.id.textView6)
        val textView7:TextView=view.findViewById(R.id.textView7)


        //val textView2: TextView = view.findViewById(R.id.text2)
        val image: ImageView = view.findViewById(R.id.imgcm1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val rowView = inflater.inflate(R.layout.list1, parent, false)
        return CustomAdapter.ViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.textView6.text = list.get(position).title
        holder.textView7.text = list.get(position).dt

        holder.image.setOnClickListener {
            val intent=Intent(context,Coinmaster1::class.java)
            intent.putExtra("link",list.get(position).link)
            intent.putExtra("description",list.get(position).description)
            intent.putExtra("dt",list.get(position).dt)
            context.startActivity(intent)
        }



        Log.e("list>>>>>>", list.get(position).title + "")
        // holder.image1.setImageResource(image[position])
        Glide.with(context)
            .load(list.get(position).img)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
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