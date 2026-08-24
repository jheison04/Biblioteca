package com.example.bibliotecacompose.ui.screen

import com.example.bibliotecacompose.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color

val moradoAzulado = Color(0xFF6257C7)

@Composable
fun InicioScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.bibliteca),
            contentDescription = "Imagen de una biblioteca",
            modifier = Modifier.size(220.dp)
        )

        Spacer(
            modifier = Modifier.height(70.dp)
        )

        Text(
            text = "¡Bienvenido a tu biblioteca!",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Descubre, aprende y reserva tus libros favoritos.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                navController.navigate("lista")
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = moradoAzulado,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .height(50.dp)
        ) {
            Text(
                text = "Ver libros"
            )
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // --- NUEVO BOTÓN PARA IR A MIS RESERVAS ---
        Button(
            onClick = {
                navController.navigate("reservas")
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF20A94B),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(0.65f)
                .height(50.dp)
        ) {
            Text(
                text = "Mis reservas"
            )
        }
    }
}