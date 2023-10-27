package com.julyleon.proyecto_campeonato

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.julyleon.proyecto_campeonato.InicioSesion.Clave.icon
import com.julyleon.proyecto_campeonato.InicioSesion.Correo.icon
import com.julyleon.proyecto_campeonato.ui.theme.Blanco
import com.julyleon.proyecto_campeonato.ui.theme.Proyecto_CampeonatoTheme
import com.julyleon.proyecto_campeonato.ui.theme.Verde

data class BottomBarDestinations(
    val ruta: String,
    val selectedIcon: ImageVector,
    val iconTextId: Int
)

val BOTTOM_BAR = listOf(
    BottomBarDestinations(
        ruta = Rutas.HOME,
        selectedIcon = Icons.Default.Home,
        iconTextId = R.string.home
    ),
    BottomBarDestinations(
        ruta = Rutas.TORNEO,
        selectedIcon = Icons.Default.Star,
        iconTextId = R.string.home
    ),
    BottomBarDestinations(
        ruta = Rutas.CUENTA,
        selectedIcon = Icons.Default.AccountCircle,
        iconTextId = R.string.cuenta
    )
)

object Rutas {
    const val HOME = "home"
    const val TORNEO = "torneo"
    const val CUENTA = "cuenta"
}


class Home : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_CampeonatoTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Principal()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Principal() {

        Scaffold(
            topBar = {
                BottomAppBar(
                    containerColor = Verde,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.menu) ,
                            contentDescription = "Menu",
                            tint = Blanco,
                            modifier = Modifier
                                .size(40.dp)


                        )
                        Text(
                            text = "Home",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = Verde,
                    contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Home ,
                        contentDescription = "Home",
                        tint = Blanco,
                        modifier = Modifier
                            .size(40.dp)
                            .weight(1f)

                    )
                    Spacer(modifier = Modifier.padding())
                    Icon(
                        painter = painterResource(id = R.drawable.torneo),
                        contentDescription = "Torneo",
                        tint = Blanco,
                        modifier = Modifier
                            .size(40.dp)
                            .weight(1f)

                    )
                    Spacer(modifier = Modifier.padding())
                    Icon(
                        painter = painterResource(id = R.drawable.usuario),
                        contentDescription = "Perfil",
                        tint = Blanco,
                        modifier = Modifier
                            .size(40.dp)
                            .weight(1f)

                    )
                }
            }
        },
    ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFFFF7E2))
            ) /*{
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = "imagen de fondo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        */
    }
}



@Preview(showSystemUi = true)
@Composable
fun PreviewHome() {
    Proyecto_CampeonatoTheme {
        Principal()
    }
}
