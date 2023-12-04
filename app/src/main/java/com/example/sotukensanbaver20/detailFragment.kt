package com.example.sotukensanbaver20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.sotukensanbaver20.databinding.ActivityCameraBinding
import com.example.sotukensanbaver20.databinding.FragmentDetailBinding
import com.example.sotukensanbaver20.databinding.FragmentNamingBinding

class detailFragment : Fragment() {
    private val args:detailFragmentArgs by navArgs()

    private val viewModel: MyViewModel by viewModels {
        MyViewModelFactory((requireActivity().application as MyApplication).repository)
    }

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
                detailFragmentDirections.actionDetailFragmentToNamingFragment(args.name, args.type)
            )
        }
        binding.registerBtn.setOnClickListener {
            viewModel.insert(MyEntity(name = args.name!!, type = args.type))
            (requireActivity() as CameraActivity).startMainActivity(args.type)
        }
        return binding.root
    }
}