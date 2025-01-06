package com.hector.projectecafeteria.compres.pagamentFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hector.projectecafeteria.compres.OrderSharedViewModel
import com.hector.projectecafeteria.databinding.ItemBinding
import com.bumptech.glide.Glide

class ItemAdapter(
    val context: Context,
    val orderDataset: List<Item>,
    private val sharedViewModel: OrderSharedViewModel
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.textViewItemNom.text = item.name
            val priceWithCurrency = item.price.toString() + "€"
            binding.textViewItemPreu.text = priceWithCurrency
            binding.textViewItemDesc.text = item.description
            Glide.with(binding.imageViewItem.context).load(item.photo).into(binding.imageViewItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = orderDataset[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return orderDataset.size
    }
}