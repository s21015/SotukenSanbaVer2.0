package com.example.sotukensanbaver20

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel(private val repository: MyRepository) : ViewModel() {
    val allEntities: LiveData<List<MyEntity>> = repository.getAllEntities()

    fun getType(type: Int): LiveData<List<MyEntity>> {
        return repository.getType(type)
    }

    fun getEnd(): LiveData<List<MyEntity>> {
        return repository.getEnd()
    }
    fun insert(entity: MyEntity) {
        viewModelScope.launch {
            repository.insert(entity)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}
class MyViewModelFactory(private val repository: MyRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MyViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}