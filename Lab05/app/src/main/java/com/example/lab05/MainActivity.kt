package com.example.lab05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, R.string.hello, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate: MenuInflater = menuInflater

        inflate.inflate(R.menu.menuopc, menu)

        return true
    }

    fun calc(view: View) {
        val preco = findViewById<EditText>(R.id.et1)
        val qtd = findViewById<EditText>(R.id.et2)
        val textView = findViewById<TextView>(R.id.tv1)
        val iva = findViewById<CheckBox>(R.id.ckb1)

        if (qtd.text.toString() == "" || preco.text.toString() == "") {

        } else {
            if (iva.isChecked()) {
                val total = preco.text.toString().toInt() * qtd.text.toString().toInt() * 1.23
                textView.setText(total.toString())
            } else {
                val total = preco.text.toString().toInt() * qtd.text.toString().toInt()
                textView.setText(total.toString())
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.opc1 -> {
                val preco = findViewById<EditText>(R.id.et1)
                val qtd = findViewById<EditText>(R.id.et2)
                val textView = findViewById<TextView>(R.id.tv1)

                preco.setText("")
                qtd.setText("")
                textView.setText("")

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}