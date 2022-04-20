package com.example.lab08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab08.adapters.TodoAdapter
import com.example.lab08.models.Todo
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = TodoAdapter(ArrayList())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodo.text.toString()
            val todoCont = etCont.text.toString()

            if (todoTitle.isNotEmpty() && todoCont.isNotEmpty()) {
                val todo = Todo(todoTitle, todoCont, LocalDate.now())

                todoAdapter.addTodo(todo)

                etTodo.text.clear()
            }
        }
    }
}