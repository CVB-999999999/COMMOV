package com.example.labpers02

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labpers02.model.Person
import com.example.labpers02.viewModel.PersonViewModel
import com.example.labpers02.viewModel.PersonViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    private val personViewModel: PersonViewModel by viewModels {
        PersonViewModelFactory((application as WordApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        personViewModel.allPeople.observe(this, Observer { name ->
            // Update the cached copy of the words in the adapter.
            name?.let { adapter.submitList(it) }
        })

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
//            data?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let {
//                val word = Person(it)
//                personViewModel.insert(word)
//            }
//        } else {
//            Toast.makeText(
//                applicationContext,
//                R.string.empty_not_saved,
//                Toast.LENGTH_LONG).show()
//        }
//    }

}