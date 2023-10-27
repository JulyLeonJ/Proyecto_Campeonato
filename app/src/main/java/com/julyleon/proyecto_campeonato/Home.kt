@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.julyleon.proyecto_campeonato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.julyleon.proyecto_campeonato.ui.theme.Proyecto_CampeonatoTheme
import com.julyleon.proyecto_campeonato.ui.theme.Verde


class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_CampeonatoTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Inicio()
                }
            }
        }
    }
}


@Composable
fun TopAppBar(
    title: @Composable() () -> Unit,
    color: Modifier = Modifier.background(color = Color(0xFF555F46)),
    navigationIcon: @Composable() (() -> Unit)? = null
) {
}

@Composable
fun Inicio() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFF7E2))
    ) {
        // La TopAppBar debe estar dentro del Box
        TopAppBar(
            title = { Text(text = "AppBar") },
            navigationIcon = {
                AppBarIcon(
                    icon = painterResource(id = R.drawable.menu)
                ) {
                    // Abre el cajón de navegación
                }
            }
        )
    }

}


@Composable
fun AppBarIcon(icon: Any, content: () -> Unit) {

}


@Preview(showSystemUi = true)
@Composable
fun PreviewInicio() {
    Inicio()
}
