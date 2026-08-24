package com.example.bibliotecacompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import com.example.bibliotecacompose.ui.model.Libro
import com.example.bibliotecacompose.ui.model.reservasMock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleReservaScreen(
    navController: NavController,
    libro: Libro,
    fechaReserva: String,
    codigoReserva: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle de Reserva", fontWeight = FontWeight.Bold) },
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "✓ Argumentos recibidos",
                color = Color(0xFF20A94B),
                modifier = Modifier
                    .border(1.dp, Color(0xFF20A94B), RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = libro.image),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("Nombre:", fontWeight = FontWeight.Bold)
                    Text(libro.titulo)
                    Text("Autor:", fontWeight = FontWeight.Bold)
                    Text(libro.autor)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Divider()
            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Fecha Reserva: ${fechaReserva.replace('-', '/')}")
                Text("Código Reserva: $codigoReserva")
                Text("Estado: Activa", color = Color(0xFF20A94B), fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(
                    onClick = { navController.navigate("renovarReserva/${libro.id}/$fechaReserva") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF20A94B)),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Renovar Reserva")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        reservasMock.removeAll { it.codigo == codigoReserva }

                        navController.popBackStack("reservas", inclusive = false)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancelar Reserva")
                }
            }
        }
    }
}