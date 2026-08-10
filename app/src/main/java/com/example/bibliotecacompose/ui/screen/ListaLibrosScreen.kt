package com.example.bibliotecacompose.ui.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bibliotecacompose.ui.components.LibroCard
import com.example.bibliotecacompose.ui.model.Libro
import androidx.navigation.NavController
import com.example.bibliotecacompose.R

@Composable

fun ListaLibrosScreen(navController: NavController){
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
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Mis libros",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 6.dp)
            )

            Text(
                text = "Elegí un libro para ver detalle",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(libros) { libro ->

            LibroCard(
                libro = libro,
                onClick = {
                    navController.navigate("detalle/${libro.id}")
                }
            )
        }
    }
}
