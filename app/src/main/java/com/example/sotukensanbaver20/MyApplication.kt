package com.example.sotukensanbaver20

import android.app.Application
import androidx.annotation.WorkerThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@WorkerThread
class MyApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { MyDatabase.getDatabase(this) }
    val repository by lazy { MyRepository(database.MyDao()) }
}