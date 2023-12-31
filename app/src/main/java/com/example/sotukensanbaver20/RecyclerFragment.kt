package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sotukensanbaver20.database.MyApplication
import com.example.sotukensanbaver20.database.MyViewModel
import com.example.sotukensanbaver20.database.MyViewModelFactory
import com.example.sotukensanbaver20.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {
    private val args: RecyclerFragmentArgs by navArgs()

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

        val activity = activity as? MainActivity

        when (args.type) {
            1 -> activity?.setTopText(R.string.animalText)
            2 -> activity?.setTopText(R.string.plantText)
            3 -> activity?.setTopText(R.string.insectText)
            4 -> activity?.setTopText(R.string.othersText)
        }

        adapter = MyAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.getType(type = args.type).observe(viewLifecycleOwner, Observer { entities ->
            entities?.let {
                adapter.submitList(it)
            }
        })

        binding.recyclerView.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)

        viewModel.getType(type = args.type).observe(viewLifecycleOwner, Observer { entities ->
            entities?.let {
                binding.textView4.setText(it.size.toString() + "しゅるい")
            }
        })

        return binding.root
    }
}