package com.example.quickreply.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quickreply.R
import com.example.quickreply.data.model.Message

class HomeFragmentAdapter(
    private val onItemClick: (Message, Int) -> Unit
) : RecyclerView.Adapter<HomeFragmentAdapter.MyViewHolder>() {

    private var messageList: MutableList<Message> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.home_rv_item_view_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val message = messageList[position]
        holder.tvMessage.text = message.message
        holder.itemView.setOnClickListener {
            onItemClick(message, position)
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMessage: TextView = itemView.findViewById(R.id.tvDisplayMessage)
    }

    fun submitList(newList: List<Message>) {
        messageList = newList.toMutableList()
        notifyDataSetChanged()
    }
}
