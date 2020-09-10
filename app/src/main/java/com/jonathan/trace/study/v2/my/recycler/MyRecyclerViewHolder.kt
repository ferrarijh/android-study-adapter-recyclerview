package com.jonathan.trace.study.v2.my.recycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jonathan.trace.study.v2.R

class MyRecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val textView: TextView = itemView.findViewById(R.id.recyclerTextView)
    private val imgView: ImageView = itemView.findViewById(R.id.recyclerImageView)

    fun bind(d: MyRecyclerData){
        textView.text = d.img_profile
        Glide.with(itemView).load(d.img_data).into(imgView)
    }
}