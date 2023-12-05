package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sotukensanbaver20.database.MyApplication
import com.example.sotukensanbaver20.database.MyViewModel
import com.example.sotukensanbaver20.database.MyViewModelFactory
import com.example.sotukensanbaver20.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {
    private val args:RecyclerFragmentArgs by navArgs()

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

        viewModel.getType(args.type).observe(viewLifecycleOwner, Observer { myEntityList ->
            // LiveDataから値を取り出して条件分岐
            when {
                myEntityList == null -> {
                    view?.let {
                        Navigation.findNavController(it).navigate(
                            RecyclerFragmentDirections.recyclerTolistNull()
                        )
                    }
                    activity?.setTopText(R.string.nullText)
                }
                myEntityList.isEmpty() -> {
                    view?.let {
                        Navigation.findNavController(it).navigate(
                            RecyclerFragmentDirections.recyclerTolistNull()
                        )
                    }
                    activity?.setTopText(R.string.nullText)
                }
                else -> {
                    // リストが空でない場合の処理
                    val firstEntity = myEntityList.first()
                    when (firstEntity.type) {
                        1 -> {
                            activity?.setTopText(R.string.animalText)
                        }
                        2 -> {
                            activity?.setTopText(R.string.plantText)
                        }
                        3 -> {
                            activity?.setTopText(R.string.insectText)
                        }
                        4 -> {
                            activity?.setTopText(R.string.othersText)
                        }

                    }
                }
            }
        })



        adapter = MyAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.getType(type = args.type).observe(viewLifecycleOwner, Observer { entities ->
            entities?.let { adapter.submitList(it) }
        })

        binding.recyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)

        binding.deleteButton.setOnClickListener {
            viewModel.deleteAll()
        }

        return binding.root
    }
}