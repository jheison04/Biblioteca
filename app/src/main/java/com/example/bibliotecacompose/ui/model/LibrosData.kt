package com.example.bibliotecacompose.ui.model

import com.example.bibliotecacompose.R
val libros = listOf(
    Libro(
        id = 1,
        titulo = "Clean Code",
        autor = "Robert C. Martin",
        categoria = "Programación",
        descripcion = "Buenas prácticas para escribir código limpio.",
        image = R.drawable.clean
    ),
    Libro(
        id = 2,
        titulo = "Kotlin para Android",
        autor = "Autor de ejemplo",
        categoria = "Android",
        descripcion = "Introducción al desarrollo de aplicaciones Android.",
        image = R.drawable.kotlin

    ),
    Libro(
        id = 3,
        titulo = "Arquitectura de Software",
        autor = "Autor de ejemplo",
        categoria = "Software",
        descripcion = "Conceptos fundamentales de arquitectura de software.",
        image = R.drawable.arquitectura

    ),
    Libro(
        id = 4,
        titulo = "Jetpack Compose",
        autor = "Autor de ejemplo",
        categoria = "Android",
        descripcion = "Desarrollo de interfaces modernas con Compose.",
        image = R.drawable.jetpack
    )
)
