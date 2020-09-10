package com.jonathan.trace.study.v2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jonathan.trace.study.v2.my.recycler.MyRecyclerAdapter
import com.jonathan.trace.study.v2.my.recycler.MyRecyclerData
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    lateinit var myRecyclerAdapter: MyRecyclerAdapter
    var data = mutableListOf<MyRecyclerData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        //1) set adapter of RecyclerView(here fragment_home.xml holds it),
        //2) load data into each view component
        super.onViewCreated(view, savedInstanceState)
        myRecyclerAdapter = MyRecyclerAdapter(view.context)
        rv_home.adapter = myRecyclerAdapter
        loadData()
    }

    private fun loadData(){
        data.apply{
            add(MyRecyclerData("lion1",
                "https://cdn.hswstatic.com/gif/lion.jpg")
            )
            add(MyRecyclerData("lion2",
                "https://www.goway.com/media/cache/aa/79/aa79264f49aae4d4b2d77f0abdeb16fc.jpg")
            )
            add(MyRecyclerData("lion3",
                "https://vignette.wikia.nocookie.net/disney/images/3/37/Profile_-_Simba.jpeg/revision/latest/top-crop/width/360/height/360?cb=20190312043852")
            )
        }
        //viewpager won't display anything without below two lines.
        myRecyclerAdapter.data = data
        myRecyclerAdapter.notifyDataSetChanged()
    }
}