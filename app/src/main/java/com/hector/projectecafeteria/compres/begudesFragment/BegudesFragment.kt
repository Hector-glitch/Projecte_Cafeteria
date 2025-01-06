package com.hector.projectecafeteria.compres.begudesFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hector.projectecafeteria.compres.OrderSharedViewModel
import com.hector.projectecafeteria.databinding.FragmentBegudesBinding

class BegudesFragment : Fragment() {

    private val viewModel: BegudesViewModel by viewModels()
    private lateinit var binding: FragmentBegudesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBegudesBinding.inflate(inflater)
        val drinkRecyclerView = binding.begudaReciclerView

        drinkRecyclerView.layoutManager = LinearLayoutManager(context)
        drinkRecyclerView.setHasFixedSize(true)

        val sharedViewModel: OrderSharedViewModel = ViewModelProvider(requireActivity()).get(
            OrderSharedViewModel::class.java
        )

        viewModel.getBegudes()
        viewModel.begudes.observe(viewLifecycleOwner) { drinksList ->
            val drinkAdapter = BegudesAdapter(requireContext(), drinksList, sharedViewModel)
            drinkRecyclerView.adapter = drinkAdapter
        }

        return binding.root
    }

}