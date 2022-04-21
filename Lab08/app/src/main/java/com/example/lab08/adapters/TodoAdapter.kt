package com.example.lab08.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab08.R
import com.example.lab08.models.Todo
import kotlinx.android.synthetic.main.todo_line.view.*

class TodoAdapter(
    private val todos: ArrayList<Todo>
) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.todo_line, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todos[position]
        var ct = "pequeno"

        if (currentTodo.nHabitantes > 200 && currentTodo.nHabitantes < 500) {
            ct = "médio"
        } else if (currentTodo.nHabitantes > 499) {
            ct = "grande"
        }

        holder.pais.text = currentTodo.pais + ": " + ct
        holder.capital.text = currentTodo.capital
        holder.count.text = (currentTodo.nDistritos + currentTodo.nFreguesias).toString()
        holder.nHabitantes.text = currentTodo.nHabitantes.toString() + " Habitantes"
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyDataSetChanged()
    }
}

class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val pais = itemView.todoPais
    val capital = itemView.todoCapital
    val count = itemView.todoCount
    val nHabitantes = itemView.todoNHabitantes
}