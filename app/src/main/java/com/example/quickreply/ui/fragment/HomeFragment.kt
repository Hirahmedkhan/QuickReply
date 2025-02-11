package com.example.quickreply.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickreply.R
import com.example.quickreply.data.model.Message
import com.example.quickreply.databinding.FragmentHomeBinding
import com.example.quickreply.ui.adapter.HomeFragmentAdapter
import com.example.quickreply.ui.viewmodel.MessageViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomeFragmentAdapter
    private val messageViewModel: MessageViewModel by viewModels()

    private var selectedMessage: Message? = null
    private var selectedPosition: Int? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        adapter = HomeFragmentAdapter { message, position ->
            onMessageClick(message.message, position)
        }

        binding.rvTextForAutoReply.adapter = adapter
        binding.rvTextForAutoReply.layoutManager = LinearLayoutManager(requireContext())


        binding.btnEditMessage.setOnClickListener {
            selectedMessage?.let { message ->
                val updatedMessage =
                    message.copy(message = binding.edtTextSetReplyMessage.text.toString())
                messageViewModel.updateMessage(updatedMessage)
            }
        }

        messageViewModel.allMessages.observe(viewLifecycleOwner) { messages ->
            adapter.submitList(messages)
        }

        binding.switchOption.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                openNotificationSettings()
            }
        }
    }

    private fun onMessageClick(message: String, position: Int) {
        binding.edtTextSetReplyMessage.setText(message)
        selectedMessage = messageViewModel.allMessages.value?.get(position)
        selectedPosition = position
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