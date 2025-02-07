package com.example.quickreply.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quickreply.R
import com.example.quickreply.ui.adapter.ViewPagerAdapter
import com.example.quickreply.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Lifecycle", "Created!")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.whatsappdarkgreen)

        val adapter = ViewPagerAdapter(this)
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

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "Starting..")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "Paused")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "Resumed")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "Stopping...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "Destroyed!")
    }

}
