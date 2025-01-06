package com.hector.projectecafeteria.compres.menjarFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hector.projectecafeteria.compres.OrderSharedViewModel
import com.hector.projectecafeteria.databinding.FragmentMenjarBinding

class MenjarFragment : Fragment() {
    private val viewModel: MenjarViewModel by viewModels()
    private lateinit var binding: FragmentMenjarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenjarBinding.inflate(inflater)
        val mealRecyclerView = binding.menjarReciclerView

        mealRecyclerView.layoutManager = LinearLayoutManager(context)
        mealRecyclerView.setHasFixedSize(true)

        val sharedViewModel: OrderSharedViewModel = ViewModelProvider(requireActivity()).get(
            OrderSharedViewModel::class.java
        )

        viewModel.getMenjars()
        viewModel.menjar.observe(viewLifecycleOwner) { menjarList ->
            val mealAdapter = MenjarAdapter(requireContext(), menjarList, sharedViewModel)
            mealRecyclerView.adapter = mealAdapter
        }

        return binding.root
    }

}