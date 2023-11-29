package com.example.sotukensanbaver20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.WorkerThread
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : ListAdapter<MyEntity, MyAdapter.YourViewHolder>(YourDiffCallback()) {

    @WorkerThread
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_items, parent, false)
        return YourViewHolder(view)
    }

    @WorkerThread
    override fun onBindViewHolder(holder: YourViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    @WorkerThread
    class YourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val named: TextView = itemView.findViewById(R.id.text_view)

        fun bind(entity: MyEntity) {
            named.text = entity.name
        }
    }

    @WorkerThread
    class YourDiffCallback : DiffUtil.ItemCallback<MyEntity>() {
        override fun areItemsTheSame(oldItem: MyEntity, newItem: MyEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MyEntity, newItem: MyEntity): Boolean {
            return oldItem == newItem
        }
    }
}