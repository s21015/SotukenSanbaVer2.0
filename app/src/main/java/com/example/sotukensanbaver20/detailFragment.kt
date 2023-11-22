package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.sotukensanbaver20.databinding.FragmentDetailBinding

class detailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.returnBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(
                detailFragmentDirections.actionDetailFragmentToNamingFragment()
            )
        }

        return binding.root
    }
}