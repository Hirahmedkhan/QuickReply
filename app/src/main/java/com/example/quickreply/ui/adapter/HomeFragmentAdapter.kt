package com.example.quickreply.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.quickreply.R

class HomeFragmentAdapter(
    private var messageList: MutableList<String>,
    private val onItemClick: (String, Int) -> Unit
) : Adapter<HomeFragmentAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.home_rv_item_view_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvMessage.text = messageList[position]

        holder.itemView.setOnClickListener {
            //messageList[position]......is position pe jo bhi data mojud hai usko fetch kr lo
            onItemClick(messageList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMessage: TextView = itemView.findViewById(R.id.tvDisplayMessage)
    }

    fun updateItem(position: Int, updatedText: String) {
        if (position in messageList.indices) {
            messageList[position] = updatedText
            notifyItemChanged(position)
        }
    }
}

