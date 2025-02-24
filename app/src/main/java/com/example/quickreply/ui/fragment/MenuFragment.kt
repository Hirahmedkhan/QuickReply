package com.example.quickreply.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickreply.R
import com.example.quickreply.data.model.ItemModel
import com.example.quickreply.databinding.FragmentMenuBinding
import com.example.quickreply.ui.adapter.ItemAdapter

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)


        val itemList = listOf(
            ItemModel("Supported Apps", "This is description for item 1", R.drawable.apps, R.id.action_dashboardFragment_to_supportedAppsFragment2),
            ItemModel("Custom Reply", "This is description for item 2", R.drawable.custom_reply),
            ItemModel("Spreadsheet", "This is description for item 3", R.drawable.spreadsheet_2),
            ItemModel("Welcome Message", "This is description for item 4", R.drawable.welcome_message),
            ItemModel("Connect To Server", "This is description for item 5", R.drawable.server),
            ItemModel("Menu Reply", "This is description for item 6", R.drawable.message),
            ItemModel("Notes", "This is description for item 7", R.drawable.notes)
        )

        val adapter = ItemAdapter(itemList){

        }
        binding.rvItemList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvItemList.adapter = adapter

    }

}