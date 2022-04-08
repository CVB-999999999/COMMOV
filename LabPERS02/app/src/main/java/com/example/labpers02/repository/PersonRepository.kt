package com.example.labpers02.repository

import androidx.annotation.WorkerThread
import com.example.labpers02.dao.PersonDao
import com.example.labpers02.model.Person
import kotlinx.coroutines.flow.Flow

class PersonRepository(private val personDao: PersonDao) {

    val allPeople: Flow<List<Person>> = personDao.getOrderPeople()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(person: Person) {
        personDao.insert(person)
    }
}