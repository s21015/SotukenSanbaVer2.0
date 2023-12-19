package com.example.sotukensanbaver20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sotukensanbaver20.database.MyApplication
import com.example.sotukensanbaver20.database.MyViewModel
import com.example.sotukensanbaver20.database.MyViewModelFactory
import com.example.sotukensanbaver20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val put = Put()

    private val viewModel: MyViewModel by viewModels {
        MyViewModelFactory((application as MyApplication).repository)
    }
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

        viewModel.getCount().observe(this, Observer { entities ->
            entities?.let {
                if (it == 0) {
                    put.insertData(viewModel,this)
                }
            }
        })

        binding.cameraBtn.setOnClickListener {
            val intent = Intent(application, CameraActivity::class.java)
            //launcher.launch(intent)
            intent.putExtra("imgType",0)
            startActivity(intent)
        }

        binding.optionBtn.setOnClickListener {
            val intent = Intent(application, CameraActivity::class.java)
            intent.putExtra("imgType", 1)
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

