package com.example.sotukensanbaver20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.sotukensanbaver20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//test
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cameraBtn.setOnClickListener {
            val intent = Intent(application,CameraActivity::class.java)
            startActivity(intent)
        }

        binding.illustratedBtn.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.illustratedFragment)
        }
//              動物画面確認用
//            navController.navigate(R.id.action_mainFragment_to_animalFragment)
    }
    fun setTopText(text: Int) {
        binding.titleText.setText(text)
    }
}
