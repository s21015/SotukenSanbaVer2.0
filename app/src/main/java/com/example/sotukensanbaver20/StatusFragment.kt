package com.example.sotukensanbaver20

import android.app.AlertDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Matrix
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
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
import java.io.FileNotFoundException

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
//                    viewModel.deleteAll()
                }
                .setNegativeButton("キャンセル") { dialog, which ->
                    // キャンセルボタンがクリックされたときの処理
                }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        viewModel.getItem(args.id).observe(viewLifecycleOwner, Observer { entities ->
            entities?.let {
                fun getBitmapFromUri(uri: String): Bitmap? {
                    try {
                        val bitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver, Uri.parse(it.uri))
                        val matrix = Matrix()
                        if (bitmap.width > 400 || bitmap.height > 400) {
                            matrix.postRotate(90f)
                        }
                        matrix.postScale(0.5f, 0.5f)
                        val scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, false)
                        return scaledBitmap
                    } catch (e: FileNotFoundException) {
                        // 画像が見つからない場合のエラー処理
                        e.printStackTrace()
                        return null
                    }
                }

                val scaledBitmap = getBitmapFromUri(it.uri)

                if (it.uri != null) {
                    binding.imageView2.setImageBitmap(scaledBitmap)
                }
                binding.editText.setText(it.name)
                binding.detailText.setText(it.detail)

                if (it.type == 5) {
                    binding.deleteBtn.visibility = View.INVISIBLE
                    binding.imageView2.setBackgroundColor(Color.WHITE)
                }
            }
        })

        binding.deleteBtn.setOnClickListener {
            showAlertDialog()
        }

        return binding.root
    }
}