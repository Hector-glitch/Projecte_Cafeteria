package com.hector.projectecafeteria.compres.pagamentFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hector.projectecafeteria.R
import com.hector.projectecafeteria.compres.OrderSharedViewModel
import com.hector.projectecafeteria.databinding.FragmentPagamentBinding

class PagamentFragment : Fragment() {
    private val viewModel: PagamentViewModel by viewModels()
    private lateinit var binding: FragmentPagamentBinding

    @SuppressLint("StringFormatInvalid")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagamentBinding.inflate(inflater)
        val totalTextView = binding.TotalTextView

        val sharedViewModel: OrderSharedViewModel = ViewModelProvider(requireActivity())[OrderSharedViewModel::class.java]

        val combinedRecyclerView = binding.combinedRecyclerView
        combinedRecyclerView.layoutManager = LinearLayoutManager(context)
        combinedRecyclerView.setHasFixedSize(true)

        sharedViewModel.getOrder()
        sharedViewModel.order.observe(viewLifecycleOwner) { orderList ->
            Log.d("RecyclerView", "OrderList size: ${orderList.size}")

            val itemAdapter = ItemAdapter(requireContext(), orderList, sharedViewModel)
            combinedRecyclerView.adapter = itemAdapter

            viewModel.getTotal(sharedViewModel)
            viewModel.total.observe(viewLifecycleOwner) {comandaTotal ->
                totalTextView.text = getString(R.string.total, "%.2f".format(comandaTotal))
            }
        }

        return binding.root
    }
}