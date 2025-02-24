package com.example.quickreply.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.quickreply.R
import com.example.quickreply.databinding.FragmentDashboardBinding
import com.example.quickreply.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var binding: FragmentDashboardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDashboardBinding.bind(view)

        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Menu"
                1 -> tab.text = "Home"
                2 -> tab.text = "Contacts"
                3 -> tab.text = "Statistics"
            }
        }.attach()
    }
}