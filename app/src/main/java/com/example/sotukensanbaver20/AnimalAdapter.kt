package com.example.sotukensanbaver20
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val animalList: List<Int>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ryukyukenBtn: ImageButton = itemView.findViewById(R.id.ryukyukenBtn)
        val iriomoteyamanekoBtn: ImageButton = itemView.findViewById(R.id.iriomoteyamanekoBtn)
        val kanahebiBtn: ImageButton = itemView.findViewById(R.id.kanahebiBtn)
        val kinoboritokageBtn: ImageButton = itemView.findViewById(R.id.kinoboritokageBtn)
        val yanbarukuina: ImageButton = itemView.findViewById(R.id.yanbarukuinaBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_animal, parent, false)
        return AnimalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        //画像をセットする
        val animalImageResource = animalList[position]
        holder.ryukyukenBtn.setImageResource(animalImageResource)
        holder.iriomoteyamanekoBtn.setImageResource(animalImageResource)
        holder.kanahebiBtn.setImageResource(animalImageResource)
        holder.kinoboritokageBtn.setImageResource(animalImageResource)
        holder.yanbarukuina.setImageResource(animalImageResource)

    }

    override fun getItemCount(): Int {
        return animalList.size
    }
}


