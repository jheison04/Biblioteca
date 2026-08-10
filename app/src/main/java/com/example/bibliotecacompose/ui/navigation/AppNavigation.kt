package com.example.bibliotecacompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bibliotecacompose.ui.model.libros
import com.example.bibliotecacompose.ui.screen.DetalleLibroScreen
import com.example.bibliotecacompose.ui.screen.InicioScreen
import com.example.bibliotecacompose.ui.screen.ListaLibrosScreen
import com.example.bibliotecacompose.ui.screen.ReservaScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {

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

            val libroId =
                backStackEntry.arguments
                    ?.getString("libroId")
                    ?.toIntOrNull()

            val libro = libros.find {
                it.id == libroId
            }

            if (libro != null) {
                DetalleLibroScreen(
                    libro = libro,
                    navController = navController
                )
            }
        }

        composable("reserva/{libroId}") { backStackEntry ->

            val libroId =
                backStackEntry.arguments
                    ?.getString("libroId")
                    ?.toIntOrNull()

            val libro = libros.find {
                it.id == libroId
            }

            if (libro != null) {
                ReservaScreen(
                    libro = libro,
                    navController = navController
                )
            }
        }
    }
}