package com.example.sotukensanbaver20

import android.content.ContentResolver
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Matrix
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.WorkerThread
import androidx.core.graphics.createBitmap
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sotukensanbaver20.database.MyEntity
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException

class MyAdapter : ListAdapter<MyEntity, MyAdapter.YourViewHolder>(YourDiffCallback()) {

    @WorkerThread
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_items, parent, false)
        return YourViewHolder(view, parent.context.contentResolver)
    }

    @WorkerThread
    override fun onBindViewHolder(holder: YourViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    @WorkerThread
    class YourViewHolder(itemView: View, contentResolver: ContentResolver) : RecyclerView.ViewHolder(itemView) {
        val named: TextView = itemView.findViewById(R.id.text_view)
        val imaged: ImageView = itemView.findViewById(R.id.imgView)
        val contentResolver: ContentResolver = contentResolver

        fun bind(entity: MyEntity) {
            named.text = entity.name

            fun getBitmapFromUri(uri: String): Bitmap? {
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, Uri.parse(entity.uri))
                    val matrix = Matrix()
                    if (bitmap.width > 400 || bitmap.height > 400) {
                        matrix.postRotate(90f)
                    }
                    matrix.postScale(0.5f, 0.5f)
                    val scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, false)
                    return scaledBitmap
                } catch (e: FileNotFoundException) {
                    // 画像が見つからない場合のエラー処理
                    e.printStackTrace()
                    return null
                }
            }

            val scaledBitmap = getBitmapFromUri(entity.uri)

            if (entity.uri != null) {
                imaged.setImageBitmap(scaledBitmap)
            }

            if (entity.type == 5) {
                imaged.setBackgroundColor(Color.WHITE)
            }

            itemView.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    RecyclerFragmentDirections.actionRecyclerFragmentToStatusFragment(entity.id)
                )
            }
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