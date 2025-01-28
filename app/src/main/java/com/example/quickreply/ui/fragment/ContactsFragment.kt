package com.example.quickreply.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.quickreply.R
import com.example.quickreply.databinding.FragmentContactsBinding

class ContactsFragment : Fragment(R.layout.fragment_contacts) {

    private lateinit var binding: FragmentContactsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactsBinding.bind(view)

    }
}