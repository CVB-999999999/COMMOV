package com.example.lab07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

    // Criação do menu na barra de cima
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate: MenuInflater = menuInflater

        inflate.inflate(R.menu.custom_menu, menu)

        return true
    }

    // Dá as funcionalidades aos butoes do menu de opcoes
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(this, "Item 1 selecionado", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.item3 -> {
                Toast.makeText(this, "Item 2 selecionado", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.SubItem1 -> {
                Toast.makeText(this, "SubItem 1 selecionado", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
