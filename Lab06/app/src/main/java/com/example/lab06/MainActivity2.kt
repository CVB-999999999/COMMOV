package com.example.lab06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val parametro = intent.getStringExtra(PARAM_NAME)

        val textView = findViewById<TextView>(R.id.tv11)

        textView.text = parametro
    }
}