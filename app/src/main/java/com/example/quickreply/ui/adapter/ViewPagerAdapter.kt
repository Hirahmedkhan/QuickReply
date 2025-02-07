package com.example.quickreply.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.quickreply.ui.fragment.ContactsFragment
import com.example.quickreply.ui.fragment.HomeFragment
import com.example.quickreply.ui.fragment.MenuFragment
import com.example.quickreply.ui.fragment.StatisticsFragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val fragmentList = listOf(
        MenuFragment(),
        HomeFragment(),
        ContactsFragment(),
        StatisticsFragment(),
    )

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]                      //provide fragment based on position
    }
}