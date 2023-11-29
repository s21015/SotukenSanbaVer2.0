package com.example.sotukensanbaver20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.sotukensanbaver20.databinding.FragmentNamingBinding

class namingFragment : Fragment() {
    private val viewModel: MyViewModel by viewModels {
        MyViewModelFactory((requireActivity().application as MyApplication).repository)
    }

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

            val inputText = binding.editText.text.toString()
            if (inputText.isNotEmpty()) {
                viewModel.insert(MyEntity(name = inputText))
                binding.editText.text.clear()
            }
        }

        binding.miniAnimalBtn.setOnClickListener {
            binding.textView.setText("どうぶつ")
        }

        binding.miniPlantBtn.setOnClickListener {
            binding.textView.setText("しょくぶつ")
        }

        binding.miniInsectBtn.setOnClickListener {
            binding.textView.setText("むし")
        }

        binding.miniOtherBtn.setOnClickListener {
            binding.textView.setText("そのた")
        }
        return binding.root
    }
}