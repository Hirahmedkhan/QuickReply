package com.example.quickreply.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.quickreply.R
import com.example.quickreply.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_notifications -> {
//                // Handle notifications action
//                true
//            }
//            R.id.action_send_message -> {
//                // Handle send message action
//                true
//            }
//            R.id.action_more -> {
//                // Handle more (three dots) action
//                true
//            }
//            R.id.action_settings -> {
//                // Handle settings action
//                true
//            }
//            R.id.action_account -> {
//                // Handle account settings action
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }


}