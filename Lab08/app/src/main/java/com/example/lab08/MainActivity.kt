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

//        var arrayL: ArrayList<Todo>

        /*arrayL.add(Todo("Pais 10", "Capital 1", 10, 20, 100))
        arrayL.add(Todo("Pais 9", "Capital 2", 20, 40, 200))
        arrayL.add(Todo("Pais 8", "Capital 3", 30, 60, 300))
        arrayL.add(Todo("Pais 7", "Capital 4", 40, 80, 400))
        arrayL.add(Todo("Pais 6", "Capital 5", 50, 100, 500))
        arrayL.add(Todo("Pais 5", "Capital 6", 60, 120, 600))
        arrayL.add(Todo("Pais 4", "Capital 7", 70, 140, 700))
        arrayL.add(Todo("Pais 3", "Capital 8", 80, 160, 800))
        arrayL.add(Todo("Pais 2", "Capital 9", 90, 180, 900))
        arrayL.add(Todo("Pais 1", "Capital 10", 100, 200, 1000))*/

        todoAdapter.addTodo(Todo("Pais 10", "Capital 1", 10, 20, 100))
        todoAdapter.addTodo(Todo("Pais 9", "Capital 2", 20, 40, 200))
        todoAdapter.addTodo(Todo("Pais 8", "Capital 3", 30, 60, 300))
        todoAdapter.addTodo(Todo("Pais 7", "Capital 4", 40, 80, 400))
        todoAdapter.addTodo(Todo("Pais 6", "Capital 5", 50, 100, 500))
        todoAdapter.addTodo(Todo("Pais 5", "Capital 6", 60, 120, 600))
        todoAdapter.addTodo(Todo("Pais 4", "Capital 7", 70, 140, 700))
        todoAdapter.addTodo(Todo("Pais 3", "Capital 8", 80, 160, 800))
        todoAdapter.addTodo(Todo("Pais 2", "Capital 9", 90, 180, 900))
        todoAdapter.addTodo(Todo("Pais 1", "Capital 10", 100, 200, 1000))
    }
}