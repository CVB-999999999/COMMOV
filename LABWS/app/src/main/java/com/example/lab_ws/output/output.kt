package com.example.lab_ws.output

//data class User(
//    val id: Int,
//    val name: String,
//    val email: String,
//    val address: Address
//)
//data class Address(
//    val city: String,
//    val zipcode: String
//)

data class output(
    val name: name,
    val currencies: currencies,
    val capital: String
)

data class name(
    val nativeName: nativeName
)

data class nativeName(
    val por: por
)

data class por(
    val common: String
)

data class currencies(
    val EUR: EUR
)

data class EUR(
    val symbol: String
)
