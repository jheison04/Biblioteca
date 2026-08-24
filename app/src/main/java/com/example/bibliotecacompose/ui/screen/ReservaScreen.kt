package com.example.bibliotecacompose.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bibliotecacompose.ui.model.Libro
import com.example.bibliotecacompose.ui.model.Reserva
import com.example.bibliotecacompose.ui.model.reservasMock
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ReservaScreen(
    libro: Libro,
    navController: NavHostController
) {
    val fechaActual = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())

    LaunchedEffect(Unit) {
        val codigoAleatorio = "RES-${(1000..9999).random()}"
        val nuevaReserva = Reserva(
            codigo = codigoAleatorio,
            libro = libro,
            fechaReserva = fechaActual
        )
        if (reservasMock.none { it.libro.id == libro.id }) {
            reservasMock.add(nuevaReserva)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "✓",
            color = Color(0xFF20A94B),
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Reserva Exitosa",
            color = Color(0xFF20A94B),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Libro:", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = libro.titulo, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Fecha:", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = fechaActual.replace('-', '/'), fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.popBackStack("inicio", inclusive = false)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF20A94B),
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth().height(52.dp)
        ) {
            Text(text = "Volver al Inicio", fontWeight = FontWeight.Bold)
        }
    }
}