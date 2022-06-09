package com.example.lab_pers_01

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Vai buscar o SP, se não existir cria
        val sharedPreference: SharedPreferences =
            getSharedPreferences("FILE_1", Context.MODE_PRIVATE)

// Vai buscar o valor do username, se não encotrar retorna string vazia (2º parametro)
        val usernameValue = sharedPreference.getString("PREF_USERNAME", "")

//        Log.d("SHARED_PREF_AULA", "Shared Preference: $usernameValue")

// Verifica se encontrou um username
        if (usernameValue!!.isNotEmpty()) {
//            showWelcome(usernameValue)
            findViewById<EditText>(R.id.et1).hint = usernameValue
        } else {
            findViewById<EditText>(R.id.et1).hint = "Inexistente"
    }

//    private fun showWelcome(usernameValue: String) {
//        findViewById<EditText>(R.id.et1).hint = usernameValue
//
//        val btn = findViewById<Button>(R.id.btn1)
//
//        btn.text = "Logout"

// Muda o btn de login para logout
//        btn.setOnClickListener {
//            logout(it)
//        }
    }

//    private fun logout(view: View) {
//        val sharedPreference: SharedPreferences =
//            getSharedPreferences("FILE_1", Context.MODE_PRIVATE)
//
//        // Apaga o conteudo da Shared Preference
//        sharedPreference.edit().clear().apply()
//
//        showLogin()
//
//        Log.d("SHARED_PREF_AULA", "Shared Preference:")
//    }

//    // Repoem o layout inicial da app (pre login)
//    private fun showLogin() {
//        findViewById<TextView>(R.id.tv1).text = "Login"
//        findViewById<EditText>(R.id.et1).isEnabled = true
//
//        val btn = findViewById<Button>(R.id.btn1)
//
//        btn.text = "Login"
//
//// Muda o btn de logout para login
//        btn.setOnClickListener {
//            login(it)
//        }
//    }

//    fun login(view: View) {
//        val editTextUserName = findViewById<EditText>(R.id.et1)
//
//        // Guarda o nome de utilizador
//        if (editTextUserName.text.isNotEmpty()) {
//            val sharedPreference: SharedPreferences =
//                getSharedPreferences("FILE_1", Context.MODE_PRIVATE)
//
//            sharedPreference.edit()
//                .putString("PREF_USERNAME", editTextUserName.text.toString())
//                .apply()
//
////            showWelcome(editTextUserName.text.toString())
//
//            Log.d("SHARED_PREF_AULA", "Shared Preference: ${editTextUserName.text}")
//        }
//    }
}