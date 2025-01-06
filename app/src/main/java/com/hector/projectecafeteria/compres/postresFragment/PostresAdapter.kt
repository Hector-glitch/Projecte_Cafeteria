package com.hector.projectecafeteria.compres.postresFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hector.projectecafeteria.compres.OrderSharedViewModel
import com.hector.projectecafeteria.compres.pagamentFragment.Item
import com.hector.projectecafeteria.databinding.ItemPostreBinding
import com.bumptech.glide.Glide

class PostresAdapter(
    val context: Context,
    val dataset: List<Postres>,
    private val sharedViewModel: OrderSharedViewModel
) :
    RecyclerView.Adapter<PostresAdapter.PostresViewHolder>() {

    inner class PostresViewHolder(private val binding: ItemPostreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(postres: Postres) {
            binding.textViewPostresNom.text = postres.name
            val priceWithCurrency = postres.price.toString() + "€"
            binding.textViewPostresPreu.text = priceWithCurrency
            binding.textViewPostresDesc.text = postres.description
            Glide.with(binding.imageViewPostres.context).load(postres.photo)
                .into(binding.imageViewPostres)
            binding.addPostresButton.setOnClickListener {
                sharedViewModel.addElementToOrder(
                    Item(
                        postres.name,
                        postres.price,
                        postres.description,
                        postres.photo
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostresAdapter.PostresViewHolder {
        val itemBinding = ItemPostreBinding.inflate(LayoutInflater.from(context), parent, false)
        return PostresViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PostresAdapter.PostresViewHolder, position: Int) {
        val Postres = dataset[position]
        holder.bind(Postres)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}