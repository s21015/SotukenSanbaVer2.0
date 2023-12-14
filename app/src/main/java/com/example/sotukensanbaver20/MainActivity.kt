package com.example.sotukensanbaver20

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.sotukensanbaver20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onResume() {
        super.onResume()
        val type = intent.getIntExtra("type", 0)
        if (type != 0) {
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(
                IllustratedFragmentDirections.actionIllustratedFragmentToRecyclerFragment(type)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cameraBtn.setOnClickListener {
            val intent = Intent(application, CameraActivity::class.java)
            //launcher.launch(intent)
            startActivity(intent)
        }

        binding.illustratedBtn.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.illustratedFragment)
        }
    }

    fun setTopText(text: Int) {
        binding.titleText.setText(text)
    }
}

