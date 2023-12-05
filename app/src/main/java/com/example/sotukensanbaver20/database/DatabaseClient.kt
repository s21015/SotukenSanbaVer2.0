package com.example.sotukensanbaver20.database

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.room.Room

object DatabaseClient {
    private var instance: MyDatabase? = null

    @WorkerThread
    fun getInstance(context: Context): MyDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java,
                "my_database_name"
            ).build()
        }
        return instance!!
    }
}