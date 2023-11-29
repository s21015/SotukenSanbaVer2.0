package com.example.sotukensanbaver20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.sotukensanbaver20.databinding.FragmentIllustratedBinding

class IllustratedFragment : Fragment() {
    private var _binding: FragmentIllustratedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIllustratedBinding.inflate(inflater, container, false)
        val activity = activity as? MainActivity
        activity?.setTopText(R.string.illustratedText)

        binding.animalBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(
                IllustratedFragmentDirections.actionIllustratedFragmentToRecyclerFragment()
            )

        }
        return binding.root
    }
}