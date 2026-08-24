package com.example.bibliotecacompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bibliotecacompose.ui.model.reservasMock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisReservasScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mis Reservas", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    // --- BOTÓN PARA VOLVER AL INICIO ---
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
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            if (reservasMock.isEmpty()) {
                Text(
                    text = "Aún no tienes reservas activas.",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 20.dp)
                )
            } else {
                Text(
                    text = "Lista de reservas activas",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                LazyColumn {
                    items(reservasMock) { reserva ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(id = reserva.libro.image),
                                        contentDescription = "Portada",
                                        modifier = Modifier.size(80.dp)
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Column {
                                        Text("Libro: ${reserva.libro.titulo}", fontWeight = FontWeight.Bold)
                                        Text("Fecha: ${reserva.fechaReserva.replace('-', '/')}")
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text("Estado: ")
                                            Text(
                                                text = reserva.estado,
                                                color = Color.White,
                                                modifier = Modifier
                                                    .background(Color(0xFF20A94B), RoundedCornerShape(4.dp))
                                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                Button(
                                    onClick = {
                                        navController.navigate("detalleReserva/${reserva.libro.id}/${reserva.fechaReserva}/${reserva.codigo}")
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6257C7))
                                ) {
                                    Text("Ver Reserva")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}