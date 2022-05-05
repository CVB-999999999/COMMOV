package com.example.labpers02

import android.app.Application
import com.example.labpers02.db.PersonRoomDatabase
import com.example.labpers02.repository.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())


    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { PersonRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { PersonRepository(database.personDao()) }
}
