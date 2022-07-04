package com.example.labpers02.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
class Person(
    @PrimaryKey
    @ColumnInfo(name = "produto")
    val produto: String,
    @ColumnInfo(name = "preco")
    val preco: Int,
    @ColumnInfo(name = "marca")
    val marca: String
)