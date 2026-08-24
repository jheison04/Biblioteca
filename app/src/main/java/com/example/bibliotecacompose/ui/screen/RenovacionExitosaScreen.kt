package com.example.bibliotecacompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bibliotecacompose.ui.model.Libro

@Composable
fun RenovacionExitosaScreen(navController: NavController, libro: Libro, nuevaFecha: String) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "✓",
                color = Color(0xFF20A94B),
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Reserva Renovada",
                color = Color(0xFF20A94B),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = libro.image),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(libro.titulo, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Nueva Fecha:", fontWeight = FontWeight.Bold)
                    Text(nuevaFecha.replace('-', '/'))
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { navController.popBackStack("reservas", inclusive = false) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF20A94B)),
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Volver a Mis Reservas")
            }
        }
    }
}