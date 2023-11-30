package com.example.sotukensanbaver20

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class MyRepository(private val myDao: MyDao) {
    fun getAllEntities(): LiveData<List<MyEntity>> {
        return myDao.getAll()
    }

    suspend fun deleteAll() {
        return myDao.deleteAll()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(entity: MyEntity) {
        myDao.Insert(entity)
    }
}