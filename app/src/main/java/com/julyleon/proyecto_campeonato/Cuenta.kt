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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.julyleon.proyecto_campeonato.ui.theme.Blanco
import com.julyleon.proyecto_campeonato.ui.theme.Iconos
import com.julyleon.proyecto_campeonato.ui.theme.Proyecto_CampeonatoTheme
import com.julyleon.proyecto_campeonato.ui.theme.Verde

class Cuenta : ComponentActivity() {
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
                    TuCuenta()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TuCuenta() {

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
                        text = "Cuenta",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .weight(1f)
                            .size(50.dp)
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
                    .offset(y = -30.dp)
            ){

                Image(
                    painter = painterResource(id = R.drawable.pato),
                    contentDescription = "imagen de fondo",
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                        .offset(y = 20.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.editar),
                    contentDescription = "Editar",
                    tint = Iconos,
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.BottomEnd)
                        .offset(y = -150.dp)
                        .offset(x = -30.dp)
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        //.aspectRatio(1f)
                        .offset(y = 350.dp)
                ){


                    Text(
                        text = "David Santiago Rios",
                        color = Color.Black,
                        textAlign = TextAlign.Justify,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .offset(x = 20.dp)
                            .offset(y = 30.dp)
                    )
                    Spacer(modifier = Modifier.padding())
                    Icon(
                        painter = painterResource(id = R.drawable.editar),
                        contentDescription = "Editar",
                        tint = Iconos,
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.BottomEnd)
                            .offset(y = -330.dp)
                            .offset(x = -30.dp)
                    )

                    Text(
                        text = "20202578106",
                        color = Color.Black,
                        textAlign = TextAlign.Justify,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .offset(x = 20.dp)
                            .offset(y = 100.dp)
                    )
                    Spacer(modifier = Modifier.padding())
                    Icon(
                        painter = painterResource(id = R.drawable.editar),
                        contentDescription = "Editar",
                        tint = Iconos,
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.BottomEnd)
                            .offset(y = -260.dp)
                            .offset(x = -30.dp)
                    )

                    Text(
                        text = "driosm@udistrital.edu.co",
                        color = Color.Black,
                        textAlign = TextAlign.Justify,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .offset(x = 20.dp)
                            .offset(y = 160.dp)
                    )
                    Spacer(modifier = Modifier.padding())
                    Icon(
                        painter = painterResource(id = R.drawable.editar),
                        contentDescription = "Editar",
                        tint = Iconos,
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.BottomEnd)
                            .offset(y = -190.dp)
                            .offset(x = -30.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ajustamiento),
                        contentDescription = "imagen de fondo",
                        contentScale = ContentScale.Inside,
                        alignment = Alignment.Center,
                        colorFilter = ColorFilter.tint(Iconos),
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomStart)
                            .offset(y = -20.dp)
                            .offset(x = -110.dp)
                            .scale(0.3f)
                    )

                    Button(
                        onClick = { /* Acción al hacer clic */ },
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .offset(y = -30.dp)
                            .offset(x = 35.dp)

                    ) {
                        Text("Ajustes")
                    }
                    Image(
                        painter = painterResource(id = R.drawable.eliminar),
                        contentDescription = "imagen de fondo",
                        contentScale = ContentScale.Inside,
                        alignment = Alignment.Center,
                        colorFilter = ColorFilter.tint(Iconos),
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomEnd)
                            .offset(y = -20.dp)
                            .offset(x = 105.dp)
                            .scale(0.3f)
                    )
                    Button(
                        onClick = { /* Acción al hacer clic */ },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(y = -30.dp)
                            .offset(x = -40.dp)

                    ) {
                        Text("Eliminar")
                    }

                }
            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun PreviewTuCuenta() {
    Proyecto_CampeonatoTheme {
        TuCuenta()
    }
}
