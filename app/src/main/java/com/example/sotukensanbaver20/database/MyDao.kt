package com.example.sotukensanbaver20.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@WorkerThread
@Dao
interface MyDao {
    @Insert
    suspend fun Insert(myEntity: MyEntity)

    @Query("SELECT * FROM my_table_name")
    fun getAll(): LiveData<List<MyEntity>>

    @Query("DELETE FROM my_table_name")
    suspend fun deleteAll()

    @Query("SELECT * FROM my_table_name WHERE type = :type")
    fun getType(type:Int): LiveData<List<MyEntity>>

    @Update
    suspend fun Update(myEntity: MyEntity)

}