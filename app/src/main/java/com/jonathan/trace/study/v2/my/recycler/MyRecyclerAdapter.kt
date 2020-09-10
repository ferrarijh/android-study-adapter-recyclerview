package com.jonathan.trace.study.v2.my.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonathan.trace.study.v2.R

class MyRecyclerAdapter(private val context: Context): RecyclerView.Adapter<MyRecyclerViewHolder>(){
    // var data is to give return value for getItemCount() below.
    var data = mutableListOf<MyRecyclerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_recycler, parent, false)
        return MyRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRecyclerViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}