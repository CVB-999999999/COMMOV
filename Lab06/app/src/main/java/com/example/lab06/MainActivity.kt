package com.example.lab06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.content.Intent as Intent

const val PARAM_NAME = "nome"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("Formulario")
    }

    fun changeName(view: View) {
        // Vai buscar as partes do layout necessrias
        val editText = findViewById<EditText>(R.id.et1)
        val textView = findViewById<TextView>(R.id.tv1)

        // Verifica se foi introduzida uma string no editText
        if (editText.text.toString() == "") {
            // Cria um toast com um aviso
            Toast.makeText(this, "Please fill your name", Toast.LENGTH_SHORT).show()
        } else {
            // Altera o conteudo da textView com o conteudo do editText
            textView.setText(editText.text)
        }
    }

    fun goToNextPage(view: View) {
        val editText = findViewById<EditText>(R.id.et1)

        // Cria a intenção de mudar de pagina
        val intent = Intent(this, dashboardActivity::class.java).apply {
            // Manda o parametro
            putExtra(PARAM_NAME, editText.text.toString())
        }

        // muda de pagina
        startActivity(intent)
    }

    fun goToNextPage2(view: View) {
        val editText = findViewById<EditText>(R.id.et1)

        // Cria a intenção de mudar de pagina
        val intent = Intent(this, MainActivity2::class.java).apply {
            // Manda o parametro
            putExtra(PARAM_NAME, editText.text.toString())
        }

        // muda de pagina
        startActivity(intent)
    }
}