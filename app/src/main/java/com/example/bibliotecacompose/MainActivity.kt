package com.example.bibliotecacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bibliotecacompose.ui.navigation.AppNavigation
import com.example.bibliotecacompose.ui.theme.BibliotecaComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BibliotecaComposeTheme {
                AppNavigation()
            }
        }
    }
}

