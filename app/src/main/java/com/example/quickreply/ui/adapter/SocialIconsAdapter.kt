//package com.example.quickreply.ui.adapter
//
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.quickreply.databinding.ItemSocialIconBinding
//
//class SocialIconsAdapter(private val items: List<Int>) :
//    RecyclerView.Adapter<SocialIconsAdapter.ViewHolder>() {
//
//    class ViewHolder(private val binding: ItemSocialIconBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(iconResId: Int) {
//            binding.ivSocialIcon.setImageResource(iconResId)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding = ItemSocialIconBinding.inflate(
//            LayoutInflater.from(parent.context),
//            parent,
//            false
//        )
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(items[position])
//    }
//
//    override fun getItemCount(): Int = items.size
//}
