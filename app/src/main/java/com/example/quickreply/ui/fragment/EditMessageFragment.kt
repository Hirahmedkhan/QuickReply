package com.example.quickreply.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quickreply.R
import com.example.quickreply.databinding.FragmentEditMessageBinding

class EditMessageFragment : Fragment(R.layout.fragment_edit_message) {

private lateinit var binding: FragmentEditMessageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditMessageBinding.bind(view)

    }

}