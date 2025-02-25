package com.example.quickreply.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quickreply.R
import com.example.quickreply.data.model.ItemModel
import com.example.quickreply.databinding.FragmentMenuBinding
import com.example.quickreply.ui.adapter.MenuAdapter

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)

        val itemList = listOf(
            ItemModel(
                "Supported Apps",
                "This is description for item 1",
                R.drawable.apps,
                R.id.action_menuFragment_to_supportedAppsFragment)
//            ), ItemModel(
//                "Custom Reply",
//                "This is description for item 2",
//                R.drawable.custom_reply,
//                R.id.action_menuFragment_to_customReplyFragment
//            ), ItemModel(
//                "Spreadsheet",
//                "This is description for item 3",
//                R.drawable.spreadsheet_2,
//                R.id.action_menuFragment_to_spreadsheetFragment
//            ), ItemModel(
//                "Welcome Message",
//                "This is description for item 4",
//                R.drawable.welcome_message,
//                R.id.action_menuFragment_to_welcomeMessageFragment
//            ), ItemModel(
//                "Connect To Server",
//                "This is description for item 5",
//                R.drawable.server,
//                R.id.action_menuFragment_to_connectToServerFragment
//            ), ItemModel(
//                "Menu Reply",
//                "This is description for item 6",
//                R.drawable.message,
//                R.id.action_menuFragment_to_customReplyFragment
//            ), ItemModel(
//                "Notes",
//                "This is description for item 7",
//                R.drawable.notes,
//                R.id.action_menuFragment_to_notesFragment
//            )
        )
        val adapter = MenuAdapter(itemList) {
            Log.d("AdapterPosition", it.toString())
            findNavController().navigate(R.id.action_menuFragment_to_supportedAppsFragment)
//            requireActivity().findNavController(R.id.nav_host_fragment).navigate(it)
        }
        binding.rvItemList.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvItemList.adapter = adapter
    }
}