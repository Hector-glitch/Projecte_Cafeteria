package com.hector.projectecafeteria.compres.begudesFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hector.projectecafeteria.compres.OrderSharedViewModel
import com.hector.projectecafeteria.compres.pagamentFragment.Item
import com.hector.projectecafeteria.databinding.ItemBegudaBinding
import com.bumptech.glide.Glide

class BegudesAdapter(
    val context: Context,
    val dataset: List<Begudes>,
    private val sharedViewModel: OrderSharedViewModel
) :
    RecyclerView.Adapter<BegudesAdapter.BegudesViewHolder>() {

    inner class BegudesViewHolder(private val binding: ItemBegudaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(drink: Begudes) {
            binding.textViewNomBeguda.text = drink.name
            val priceWithCurrency = drink.price.toString() + "€"
            binding.textViewBegudaPreu.text = priceWithCurrency
            binding.textViewBegudaDesc.text = drink.description
            Glide.with(binding.imageViewBeguda).load(drink.photo).into(binding.imageViewBeguda)
            binding.addBegudaButton.setOnClickListener {
                sharedViewModel.addElementToOrder(
                    Item(
                        drink.name,
                        drink.price,
                        drink.description,
                        drink.photo
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BegudesAdapter.BegudesViewHolder {
        val itemBinding = ItemBegudaBinding.inflate(LayoutInflater.from(context), parent, false)
        return BegudesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BegudesAdapter.BegudesViewHolder, position: Int) {
        val drink = dataset[position]
        holder.bind(drink)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}