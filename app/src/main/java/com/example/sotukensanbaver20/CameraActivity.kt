package com.example.sotukensanbaver20

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

import com.example.sotukensanbaver20.databinding.ActivityCameraBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import com.example.sotukensanbaver20.database.MyApplication
import com.example.sotukensanbaver20.database.MyViewModel
import com.example.sotukensanbaver20.database.MyViewModelFactory

class CameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding

    private var fileUri: Uri? = null

    private val cameraResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == RESULT_OK) {
            binding.imageView2.setImageURI(fileUri)
            binding.fragmentContainerView3.findNavController().navigate(
                R.id.namingFragment, bundleOf("uri" to fileUri.toString())
            )
        }
    }

    fun startMainActivity(type: Int) {
        val intent = Intent(application, MainActivity::class.java)
        intent.putExtra("type", type)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.ROOT).format(Date())
        val filename = "${timestamp}.jpg"
        val value = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, filename)
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/PractiseCamera")
        }
        fileUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, value)
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
        }

        cameraResultLauncher.launch(intent)
    }
}