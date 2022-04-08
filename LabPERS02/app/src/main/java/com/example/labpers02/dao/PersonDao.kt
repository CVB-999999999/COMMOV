package com.example.labpers02.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.labpers02.model.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    // Flow -> info em tempo real
    // suspend -> usado não operações de CUD, não é necessario em read

    @Query("SELECT * FROM person_table ORDER BY name ASC")
    fun getOrderPeople(): Flow<List<Person>>

    @Insert(onConflict = IGNORE)
    suspend fun insert(person: Person)

    @Query("DELETE FROM person_table")
    suspend fun deleteAll()
}