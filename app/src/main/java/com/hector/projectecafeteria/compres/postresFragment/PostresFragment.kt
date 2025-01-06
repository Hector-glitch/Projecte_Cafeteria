package com.hector.projectecafeteria.compres.postresFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hector.projectecafeteria.compres.OrderSharedViewModel
import com.hector.projectecafeteria.databinding.FragmentPostresBinding

class PostresFragment : Fragment() {
    private val viewModel: PostresViewModel by viewModels()
    private lateinit var binding: FragmentPostresBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostresBinding.inflate(inflater)
        val postresRecyclerView = binding.postresReciclerView

        postresRecyclerView.layoutManager = LinearLayoutManager(context)
        postresRecyclerView.setHasFixedSize(true)

        val sharedViewModel: OrderSharedViewModel = ViewModelProvider(requireActivity()).get(
            OrderSharedViewModel::class.java)

        viewModel.getPostres()
        viewModel.postres.observe(viewLifecycleOwner) { postresList ->
            val postresAdapter = PostresAdapter(requireContext(), postresList, sharedViewModel)
            postresRecyclerView.adapter = postresAdapter
        }

        return binding.root
    }

}