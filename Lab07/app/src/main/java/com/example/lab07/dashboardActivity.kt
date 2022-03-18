package com.example.lab07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class dashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setTitle("Dashboard")

        // Recebe o parametro
        val parametro = intent.getStringExtra(PARAM_NAME)

        val textView = findViewById<TextView>(R.id.tv1Dashboard)

        textView.text = parametro

    }
}