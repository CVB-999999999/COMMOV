package com.example.labpers02.viewModel

import androidx.lifecycle.*
import com.example.labpers02.model.Person
import com.example.labpers02.repository.PersonRepository
import kotlinx.coroutines.launch

class PersonViewModel(private val repository: PersonRepository) : ViewModel() {

    val allPeople: LiveData<List<Person>> = repository.allPeople.asLiveData()

    val peopleB: LiveData<List<Person>> = repository.peopleB.asLiveData()

    fun insert(person: Person) = viewModelScope.launch {
        repository.insert(person)
    }
}

class PersonViewModelFactory(private val repository: PersonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
            @Suppress("UNCHECK_CAST")
            return PersonViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown View Model Class")
    }
}