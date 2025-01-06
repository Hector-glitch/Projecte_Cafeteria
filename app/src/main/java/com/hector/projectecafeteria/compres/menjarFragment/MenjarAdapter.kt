package com.hector.projectecafeteria.compres.menjarFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hector.projectecafeteria.compres.OrderSharedViewModel
import com.hector.projectecafeteria.compres.pagamentFragment.Item
import com.hector.projectecafeteria.databinding.ItemMenjarBinding
import com.bumptech.glide.Glide

class MenjarAdapter(
    val context: Context,
    val dataset: List<Menjar>,
    private val sharedViewModel: OrderSharedViewModel
) :
    RecyclerView.Adapter<MenjarAdapter.MenjarViewHolder>() {

    inner class MenjarViewHolder(private val binding: ItemMenjarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(menjar: Menjar) {
            binding.textViewMenjarNom.text = menjar.name
            val priceWithCurrency = menjar.price.toString() + "€"
            binding.textViewMenjarPreu.text = priceWithCurrency
            binding.textViewMenjarDesc.text = menjar.description
            Glide.with(binding.imageViewMenjar.context).load(menjar.photo)
                .into(binding.imageViewMenjar)
            binding.addMenjarButton.setOnClickListener {
                sharedViewModel.addElementToOrder(
                    Item(
                        menjar.name,
                        menjar.price,
                        menjar.description,
                        menjar.photo
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenjarAdapter.MenjarViewHolder {
        val itemBinding = ItemMenjarBinding.inflate(LayoutInflater.from(context), parent, false)
        return MenjarViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MenjarAdapter.MenjarViewHolder, position: Int) {
        val Menjar = dataset[position]
        holder.bind(Menjar)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}