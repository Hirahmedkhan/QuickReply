package com.example.quickreply.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.viewModels
import com.example.quickreply.R
import com.example.quickreply.data.model.Message
import com.example.quickreply.databinding.FragmentEditMessageBinding
import com.example.quickreply.ui.viewmodel.MessageViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditMessageFragment : BottomSheetDialogFragment(R.layout.fragment_edit_message) {

    private lateinit var binding: FragmentEditMessageBinding
    private val viewModel: MessageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditMessageBinding.bind(view)

        val selectedMessage = arguments?.getString("selected_message") ?: ""

        binding.edtMessage.setText(selectedMessage)

        binding.btnSave.setOnClickListener {
            val updatedMessage = binding.edtMessage.text.toString().trim()
            if (updatedMessage.isNotEmpty()) {
                val newMessage = Message(id = 0, message = updatedMessage)
                viewModel.insertMessage(newMessage)
                dismiss()

            } else {
                Toast.makeText(requireContext(), "Please fill in the required field!", LENGTH_SHORT)
                    .show()
            }
        }

        binding.btnDelete.setOnClickListener {
            selectedMessage.let { message ->
                viewModel.deleteMessage(Message(id= 0, message = selectedMessage ))
                dismiss()
            } ?: Toast.makeText(requireContext(), "No message selected", Toast.LENGTH_SHORT).show()
        }

    }

}
