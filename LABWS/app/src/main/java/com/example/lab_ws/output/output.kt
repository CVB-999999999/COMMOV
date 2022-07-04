package com.example.lab_ws.output

data class User(
    val independent: Boolean,
    val capital: Array<String>,
    val translations: Translations
)

data class Translations(
    val spa: Spa
)

data class Spa(
    val official: String
)