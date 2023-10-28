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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julyleon.proyecto_campeonato.InicioSesion.Clave.icon
import com.julyleon.proyecto_campeonato.InicioSesion.Correo.icon
import com.julyleon.proyecto_campeonato.ui.theme.Blanco
import com.julyleon.proyecto_campeonato.ui.theme.Proyecto_CampeonatoTheme
import com.julyleon.proyecto_campeonato.ui.theme.Verde
/*
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
        iconTextId = R.string.torneo
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

*/
class Usuario : ComponentActivity() {
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
                    User()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun User() {

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
        ) {

            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 85.dp)
            ){
                Text(
                    text = "Torneos Inscritos",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight =  FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .aspectRatio(1f)

                )
                Image(
                    painter = painterResource(id = R.drawable.pato),
                    contentDescription = "imagen de fondo",
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .offset(y = -60.dp)
                )
                Button(
                    onClick = { /* Acción al hacer clic */ },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .offset(y = -110.dp)

                ) {
                    Text("Baloncesto 2023")
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        //.aspectRatio(1f)
                        .offset(y = 350.dp)
                ){

                    Image(
                        painter = painterResource(id = R.drawable.pato),
                        contentDescription = "imagen de fondo",
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .offset(y = -20.dp)
                    )
                    Button(
                        onClick = { /* Acción al hacer clic */ },
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .offset(y = 30.dp)

                    ) {
                        Text("Voleibol 2023")
                    }

                }
            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun PreviewUser() {
    Proyecto_CampeonatoTheme {
        User()
    }
}
