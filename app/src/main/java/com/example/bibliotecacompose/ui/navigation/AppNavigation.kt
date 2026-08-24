package com.example.bibliotecacompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bibliotecacompose.ui.model.libros
import com.example.bibliotecacompose.ui.screen.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {
        // --- RUTAS ORIGINALES QUE HABÍAS BORRADO ---

        composable("inicio") {
            InicioScreen(
                navController = navController
            )
        }

        composable("lista") {
            ListaLibrosScreen(
                navController = navController
            )
        }

        composable("detalle/{libroId}") { backStackEntry ->
            val libroId = backStackEntry.arguments?.getString("libroId")?.toIntOrNull()
            val libro = libros.find { it.id == libroId }
            if (libro != null) {
                DetalleLibroScreen(
                    libro = libro,
                    navController = navController
                )
            }
        }

        composable("reserva/{libroId}") { backStackEntry ->
            val libroId = backStackEntry.arguments?.getString("libroId")?.toIntOrNull()
            val libro = libros.find { it.id == libroId }
            if (libro != null) {
                ReservaScreen(
                    libro = libro,
                    navController = navController
                )
            }
        }

        // --- NUEVAS RUTAS DE LA IMAGEN ---

        // Pantalla 1: Mis Reservas
        composable("reservas") {
            MisReservasScreen(navController = navController)
        }

        // Pantalla 2: Detalle de Reserva (Recibe 3 parámetros)
        composable("detalleReserva/{libroId}/{fechaReserva}/{codigoReserva}") { backStackEntry ->
            val libroId = backStackEntry.arguments?.getString("libroId")?.toIntOrNull()
            val fechaReserva = backStackEntry.arguments?.getString("fechaReserva") ?: ""
            val codigoReserva = backStackEntry.arguments?.getString("codigoReserva") ?: ""

            val libro = libros.find { it.id == libroId }
            if (libro != null) {
                DetalleReservaScreen(navController, libro, fechaReserva, codigoReserva)
            }
        }

        // Pantalla 3: Renovar Reserva
        composable("renovarReserva/{libroId}/{fechaActual}") { backStackEntry ->
            val libroId = backStackEntry.arguments?.getString("libroId")?.toIntOrNull()
            val fechaActual = backStackEntry.arguments?.getString("fechaActual") ?: ""

            val libro = libros.find { it.id == libroId }
            if (libro != null) {
                RenovarReservaScreen(navController, libro, fechaActual)
            }
        }

        // Pantalla 4: Renovación Exitosa
        composable("renovacionExitosa/{libroId}/{nuevaFecha}") { backStackEntry ->
            val libroId = backStackEntry.arguments?.getString("libroId")?.toIntOrNull()
            val nuevaFecha = backStackEntry.arguments?.getString("nuevaFecha") ?: ""

            val libro = libros.find { it.id == libroId }
            if (libro != null) {
                RenovacionExitosaScreen(navController, libro, nuevaFecha)
            }
        }
    }
}