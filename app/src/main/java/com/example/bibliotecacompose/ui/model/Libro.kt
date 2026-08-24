package com.example.bibliotecacompose.ui.model

data class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val categoria: String,
    val descripcion: String,
    val image: Int
)