package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sotukensanbaver20.databinding.FragmentNamingBinding
import android.util.Log

class namingFragment : Fragment() {
    private val args:namingFragmentArgs by navArgs()

    private var _binding: FragmentNamingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNamingBinding.inflate(inflater, container, false)
        val uri = args.uri
        var name = ""
        var type = 0

        if (args.name != null) {
            binding.editText.setText(args.name)
            when (args.type) {
                1 -> binding.textView.setText("どうぶつ")
                2 -> binding.textView.setText("しょくぶつ")
                3 -> binding.textView.setText("むし")
                4 -> binding.textView.setText("そのた")
            }
        }

        binding.registerBtn.setOnClickListener {
            name = binding.editText.text.toString()

            findNavController().navigate(
                namingFragmentDirections.namingToDetail(name, type, uri)
            )
        }

        val miniBtns = listOf(
            Triple(binding.miniAnimalBtn , "どうぶつ", 1),
            Triple(binding.miniPlantBtn , "しょくぶつ", 2),
            Triple(binding.miniInsectBtn , "むし", 3),
            Triple(binding.miniOtherBtn , "そのた", 4),
        )

        miniBtns.forEach { (btn, text, typeValue) ->
            btn.setOnClickListener {
                binding.textView.setText(text)
                type = typeValue
            }
        }
        return binding.root
    }
}