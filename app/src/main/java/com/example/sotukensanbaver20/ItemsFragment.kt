package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.sotukensanbaver20.databinding.FragmentRecyclerBinding

class ItemsFragment : Fragment() {
    private var _binding: FragmentRecyclerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerBinding.inflate(inflater, container, false)

        return binding.root
    }
}