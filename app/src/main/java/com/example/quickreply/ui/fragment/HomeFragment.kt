package com.example.quickreply.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickreply.HomeFragmentAdapter
import com.example.quickreply.R
import com.example.quickreply.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeFragmentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val messageList = listOf(
            "Hey there! I'm currently unavailable. I'll get back to you soon. 😊",
            "Thanks for reaching out! I'm away right now but will respond as soon as possible.",
            "Hello! I'm a bit busy at the moment. I'll reply as soon as I can. 🚀",
            "Hi! I'm not available right now. Leave a message, and I'll get back to you shortly.",
            "Hey! I'm currently occupied. I'll message you back when I'm free. Thanks for your patience! 🙏",
            "I'm away from my phone right now. I'll respond as soon as I return. 📱",
            "Hi there! I'm currently in a meeting. I'll get back to you soon.",
            "Thanks for your message! I'm out right now but will reply soon. 🕒",
            "Hey! I'm taking a short break. I'll message you back once I'm available.",
            "I'm currently offline. I'll reply when I'm back online. 🌐"
        )
        adapter = HomeFragmentAdapter(messageList)
        binding.rvTextForAutoReply.adapter = adapter
        binding.rvTextForAutoReply.layoutManager = LinearLayoutManager(requireContext())



        binding.switchOption.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                openNotificationSettings()
            }
        }
    }

    private fun openNotificationSettings() {
        val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
        startActivity(intent)
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