package com.example.sotukensanbaver20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.sotukensanbaver20.databinding.FragmentIllustratedBinding

class IllustratedFragment : Fragment() {
    private var _binding: FragmentIllustratedBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIllustratedBinding.inflate(inflater, container, false)

        val intent = Intent(activity, MainActivity::class.java)
        val titleanimal = "animal"

        binding.animalBtn.setOnClickListener {

            Navigation.findNavController(it).navigate(
                IllustratedFragmentDirections.actionIllustratedFragmentToAnimalFragment()
            )
            intent.putExtra("animal_key",titleanimal)
        }

        return binding.root
    }
}