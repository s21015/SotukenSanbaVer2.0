package com.example.sotukensanbaver20

import android.net.Uri
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class MyRepository(private val myDao: MyDao) {
    fun getAllEntities(): LiveData<List<MyEntity>> {
        return myDao.getAll()
    }

    suspend fun deleteAll() {
        return myDao.deleteAll()
    }
    fun getType(type:Int): LiveData<List<MyEntity>> {
        return myDao.getType(type)
    }
    /*fun getUri(uri: Uri): LiveData<List<MyEntity>> {
        return myDao.getUri(uri)
    }*/

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(entity: MyEntity) {
        myDao.Insert(entity)
    }
}