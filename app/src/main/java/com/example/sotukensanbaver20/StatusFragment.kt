package com.example.sotukensanbaver20

import android.app.AlertDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.sotukensanbaver20.database.MyApplication
import com.example.sotukensanbaver20.database.MyViewModel
import com.example.sotukensanbaver20.database.MyViewModelFactory
import com.example.sotukensanbaver20.databinding.FragmentStatusBinding
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class StatusFragment : Fragment() {
    private val args:StatusFragmentArgs by navArgs()

    private var _binding: FragmentStatusBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MyViewModel by viewModels {
        MyViewModelFactory((requireActivity().application as MyApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStatusBinding.inflate(inflater, container, false)

        fun showAlertDialog() {
            val builder = AlertDialog.Builder(context)

            builder.setTitle("ほんとうにさくじょしますか？")
                .setPositiveButton("OK") { dialog, which ->
                    viewModel.getItem(args.id).observe(viewLifecycleOwner, Observer { entities ->
                        entities?.let {
                            findNavController().navigate(
                                StatusFragmentDirections.actionStatusFragmentToRecyclerFragment(it.type)
                            )
                        }
                    })
                    viewModel.delete(args.id)
                }
                .setNegativeButton("キャンセル") { dialog, which ->
                    // キャンセルボタンがクリックされたときの処理
                }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        viewModel.getItem(args.id).observe(viewLifecycleOwner, Observer { entities ->
            entities?.let {
                binding.imageView2.setImageURI(Uri.parse(it.uri))
                binding.editText.setText(it.name)
                binding.detailText.setText(it.detail)
            }
        })

        binding.deleteBtn.setOnClickListener {
//            viewModel.delete(args.id)
            showAlertDialog()
        }

        return binding.root
    }
}