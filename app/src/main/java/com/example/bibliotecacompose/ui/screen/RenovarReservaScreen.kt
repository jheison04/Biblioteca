package com.example.bibliotecacompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bibliotecacompose.ui.model.Libro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenovarReservaScreen(navController: NavController, libro: Libro, fechaActual: String) {
    var nuevaFecha by remember { mutableStateOf("30-06-2026") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Renovar Reserva", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = libro.image),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text("Libro:\n${libro.titulo}", fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text("Reserva Actual:")
            Text(fechaActual.replace('-', '/'), fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nuevaFecha,
                onValueChange = { nuevaFecha = it },
                label = { Text("Nueva Fecha") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { navController.navigate("renovacionExitosa/${libro.id}/$nuevaFecha") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800)),
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Confirmar Renovación")
            }
        }
    }
}