package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sotukensanbaver20.databinding.FragmentAnimalBinding

class animalFragment : Fragment() {
    private var _binding: FragmentAnimalBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalBinding.inflate(inflater, container, false)
        val activity = activity as? MainActivity
        activity?.setTopText(R.string.animalText)
        return binding.root
    }
}