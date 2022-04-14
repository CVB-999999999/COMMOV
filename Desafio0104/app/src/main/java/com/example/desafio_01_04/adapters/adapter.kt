package com.example.desafio_01_04.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_01_04.R
import com.example.desafio_01_04.models.model
import kotlinx.android.synthetic.main.linha.view.*

class adapter(
    private val data: ArrayList<model>
) : RecyclerView.Adapter<AdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.linha, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val currentTodo = data[position]

        holder.name.text = currentTodo.name
        holder.idade.text = currentTodo.idade.toString()
        holder.sexo.text = currentTodo.sexo.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addTodo(data1: model) {
        data.add(data1)
        notifyDataSetChanged()
    }
}

class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.nome
    val idade = itemView.idade
    val sexo = itemView.sexo
}
