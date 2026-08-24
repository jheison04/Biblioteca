package com.example.bibliotecacompose.ui.model

import androidx.compose.runtime.mutableStateListOf

data class Reserva(
    val codigo: String,
    val libro: Libro,
    val fechaReserva: String,
    val estado: String = "Activa"
)

val reservasMock = mutableStateListOf<Reserva>()