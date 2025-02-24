package com.example.quickreply.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quickreply.data.model.ItemModel
import com.example.quickreply.databinding.MenuRvItemViewBinding

class ItemAdapter(
    private val itemList: List<ItemModel>, private val onItemClick: () -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(val binding: MenuRvItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            MenuRvItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.rvTitle.text = item.title
        holder.binding.rvDescription.text = item.description
        holder.binding.imgIcon.setImageResource(item.icon)
        holder.itemView.setOnClickListener {
            onItemClick()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}