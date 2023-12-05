package com.example.sotukensanbaver20

import android.net.Uri
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

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

    /*@Query("UPDATE my_table_name SET uri =  WHERE id = ")
    fun getUri(uri: Uri): LiveData<List<MyEntity>>*/

}