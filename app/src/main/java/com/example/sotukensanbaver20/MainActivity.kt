package com.example.sotukensanbaver20

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.findNavController
import com.example.sotukensanbaver20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//test
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val navController = findNavController(R.id.fragmentContainerView)
        navController.navigate(R.id.illustratedFragment)*/

        binding.cameraBtn.setOnClickListener {
            val intent = Intent(application,CameraActivity::class.java)
            //launcher.launch(intent)
            startActivity(intent)
        }

        binding.illustratedBtn.setOnClickListener {
            val navController = findNavController(R.id.fragmentContainerView)
            navController.navigate(R.id.illustratedFragment)
        }
//              動物画面確認用
//            navController.navigate(R.id.action_mainFragment_to_animalFragment)
    }

    /*private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Resultコードをチェック
        if (result.resultCode == Activity.RESULT_OK) {
            // インテントを取得
            val intent = result.data
            // 中身を取り出す
            val category = intent?.getStringExtra("category")
            //表示
            Toast.makeText(this, category, Toast.LENGTH_SHORT)
                .show()
        }
    }*/
    fun setTopText(text: Int) {
        binding.titleText.setText(text)
    }
}

