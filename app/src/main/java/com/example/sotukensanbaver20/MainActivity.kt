package com.example.sotukensanbaver20

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.findNavController
import com.example.sotukensanbaver20.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textTitle = binding.titleText
        /*val titleanimal = intent.getStringExtra("animal_key")

        if (titleanimal == "animal") {
            textTitle.setText(R.string.animalText)
        }
*/
        binding.cameraBtn.setOnClickListener {
            val intent = Intent(application,CameraActivity::class.java)
            startActivity(intent)
        }

        binding.illustratedBtn.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.illustratedFragment)
            textTitle.setText(R.string.illustratedText)
        }




//              動物画面確認用
//            navController.navigate(R.id.action_mainFragment_to_animalFragment)
    }

}
