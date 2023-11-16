package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.sotukensanbaver20.databinding.FragmentNamingBinding

class namingFragment : Fragment() {
    private var _binding: FragmentNamingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNamingBinding.inflate(inflater, container, false)

        binding.nextBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(
                namingFragmentDirections.namingToDetail()
            )
        }
        return binding.root
    }
}