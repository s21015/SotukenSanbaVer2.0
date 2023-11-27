package com.example.sotukensanbaver20
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val animalList: List<Int>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animalImage: ImageButton = itemView.findViewById(R.id.animalFragment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_animal, parent, false)
        return AnimalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animalImageResource = animalList[position]
        holder.animalImage.setImageResource(animalImageResource)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }
}
