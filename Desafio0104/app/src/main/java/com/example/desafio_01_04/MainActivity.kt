package com.example.desafio_01_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.desafio_01_04.adapters.adapter
import com.example.desafio_01_04.models.model
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Array

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addToList(view: View) {

        val nome = etNome.text.toString()
        val idade = etIdade.text.toString()
        val sexo = rdSexo.checkedRadioButtonId

//        if (sexo == M.id) {
//            tvTitle.text = sexo.toString()
//        }

        if (nome.isNotEmpty() && idade.isNotEmpty() && sexo > -1) {
            // Cria a intenção de mudar de pagina
            val intent = Intent(this, ListActivity::class.java).apply {
                // Manda o parametro
                putExtra("nome", nome)
                putExtra("idade", idade)
                putExtra("sexo", sexo)
            }

            // muda de pagina
            startActivity(intent)
        }
    }

    fun goToList(view: View) {
        // Cria a intenção de mudar de pagina
        val intent = Intent(this, ListActivity::class.java).apply {
        }

        // muda de pagina
        startActivity(intent)
    }
}