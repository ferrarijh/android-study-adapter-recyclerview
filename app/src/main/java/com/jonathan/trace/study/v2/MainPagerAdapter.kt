package com.jonathan.trace.study.v2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment = when(position){
        0 -> HomeFragment()
        1 -> LibraryFragment()
        else -> MyPageFragment()
    }

    override fun getCount(): Int = 3
}