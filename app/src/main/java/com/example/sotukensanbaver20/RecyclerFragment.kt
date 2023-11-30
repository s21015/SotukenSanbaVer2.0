package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sotukensanbaver20.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {

    private val viewModel: MyViewModel by viewModels {
        MyViewModelFactory((requireActivity().application as MyApplication).repository)
    }

    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)

        adapter = MyAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.allEntities.observe(viewLifecycleOwner, Observer { entities ->
            entities?.let { adapter.submitList(it) }
        })

        binding.recyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)

        binding.deleteButton.setOnClickListener {
            viewModel.deleteAll()
        }

        return binding.root
    }
}