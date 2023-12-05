package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.sotukensanbaver20.databinding.FragmentNamingBinding

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

        var name = ""
        var type = 0
        val uri = ""

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

            Navigation.findNavController(it).navigate(
                namingFragmentDirections.namingToDetail(name, type, uri)
            )
        }

        binding.miniAnimalBtn.setOnClickListener {
            binding.textView.setText("どうぶつ")
            type = 1
        }

        binding.miniPlantBtn.setOnClickListener {
            binding.textView.setText("しょくぶつ")
            type = 2
        }

        binding.miniInsectBtn.setOnClickListener {
            binding.textView.setText("むし")
            type = 3
        }

        binding.miniOtherBtn.setOnClickListener {
            binding.textView.setText("そのた")
            type = 4
        }
        return binding.root
    }

}