package com.tech2develop.hanumanchalisa.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tech2develop.hanumanchalisa.Fragments.BhajanFragment
import com.tech2develop.hanumanchalisa.Fragments.LyricsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, code: Int) : FragmentStateAdapter(fragmentManager, lifecycle) {
    val code = code
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0-> BhajanFragment(code)
           1-> LyricsFragment(code)
           else -> BhajanFragment(code)
       }
    }
}