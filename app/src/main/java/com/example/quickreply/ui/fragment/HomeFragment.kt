package com.example.quickreply.ui.fragment

import android.content.Context.MODE_PRIVATE
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
    private val messageViewModel: MessageViewModel by viewModels()
    private lateinit var adapter: HomeFragmentAdapter

    private var selectedMessage: Message? = null
    private var selectedPosition: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        adapter = HomeFragmentAdapter { message, position ->
            onMessageClick(message.message, position)
        }

        binding.rvTextForAutoReply.apply {
            adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding.btnEditMessage.setOnClickListener {
            val customMessage = binding.tvSetReplyMessage.text.toString().trim()
            if (customMessage.isNotEmpty()) {
                val bundle = Bundle().apply {
                    putString("selected_message", customMessage)
                }

                val editMessageFragment = EditMessageFragment().apply {
                    arguments = bundle
                }
                editMessageFragment.show(parentFragmentManager, "editMessageFragment")
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
        parentFragmentManager.addFragmentOnAttachListener { _, fragment ->
            if (fragment is EditMessageFragment) {
                fragment.dialog?.setOnDismissListener {
                    binding.tvSetReplyMessage.text = ""
                }
            }
        }

        parentFragmentManager.setFragmentResultListener("edit_message_result", viewLifecycleOwner) { _, _ ->
            binding.tvSetReplyMessage.text = ""
        }
    }

    private fun onMessageClick(message: String, position: Int) {
        binding.tvSetReplyMessage.setText(message)
        selectedMessage = messageViewModel.allMessages.value?.get(position)
        selectedPosition = position

        val sharedPreferences =
            requireContext().getSharedPreferences("AutoReplyPrefs", MODE_PRIVATE)
        sharedPreferences.edit().putString("selected_auto_reply", message).apply()
    }

    private fun openNotificationSettings() {
        startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
    }
}