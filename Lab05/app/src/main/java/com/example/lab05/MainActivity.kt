package com.example.lab05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeName(view: View) {
        // Vai buscar as partes do layout necessrias
        val editText = findViewById<EditText>(R.id.et1)
        val textView = findViewById<TextView>(R.id.tv1)

        // Verifica se foi introduzida uma string no editText
        if(editText.text.toString() == "") {
            // Cria um toast com um aviso
            Toast.makeText(this, "Please fill your name", Toast.LENGTH_SHORT).show()
        } else {
            // Altera o conteudo da tetView com o conteudo do editText
            textView.setText(editText.text)
//            textView.text = editText.text
        }
    }
}