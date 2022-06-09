package com.example.labpers02.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.labpers02.dao.PersonDao
import com.example.labpers02.model.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Person::class], version = 2, exportSchema = false)
abstract class PersonRoomDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.personDao())
                }
            }
        }

        suspend fun populateDatabase(wordDao: PersonDao) {
            // Delete all content here.
            wordDao.deleteAll()

            // Add sample words.
            var word = Person("Jõao", 21, "joao@email.com", 2020)
            wordDao.insert(word)
            word = Person("Ana", 35, "ana@email.com", 2000)
            wordDao.insert(word)

            // TODO: Add your own words!
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: PersonRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PersonRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonRoomDatabase::class.java,
                    "person_database"
                ).fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()

                INSTANCE = instance

                instance
            }
        }
    }
}