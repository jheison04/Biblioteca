package com.example.bibliotecacompose.ui.model

import android.media.Image

data class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val categoria: String,
    val descripcion: String,
    val image: Int
)