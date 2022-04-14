package com.example.desafio_01_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_01_04.adapters.adapter
import com.example.desafio_01_04.models.model
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var adaptador: adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        adaptador = adapter(ArrayList())

        lista.adapter = adaptador
        lista.layoutManager = LinearLayoutManager(this)

        val nome = intent.getStringExtra("nome")
        val idade = intent.getStringExtra("idade")
        val sexo = intent.getStringExtra("sexo")

        if (!(nome.isNullOrEmpty() && idade.isNullOrEmpty() && sexo.isNullOrEmpty())) {
            val dados = model(nome.toString(), idade.toString(), sexo.toString())

            adaptador.addTodo(dados)
        }


    }
}