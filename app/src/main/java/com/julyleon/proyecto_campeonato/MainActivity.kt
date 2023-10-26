 package com.julyleon.proyecto_campeonato

import android.content.res.Configuration
import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.julyleon.proyecto_campeonato.ui.theme.Blanco
import com.julyleon.proyecto_campeonato.ui.theme.Proyecto_CampeonatoTheme
import com.julyleon.proyecto_campeonato.ui.theme.Purple40

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Proyecto_CampeonatoTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}
@Composable
fun MyImage() {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Imagen de prueba",
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
        )
}

 @Composable
 fun Login() {

     val claveFocusRequester = FocusRequester()
     val focusManager: FocusManager = LocalFocusManager.current

     Box(
         modifier = Modifier.fillMaxSize(),
         contentAlignment = Alignment.Center
     ) {
         Image(
             painter = painterResource(id = R.drawable.fondo),
             contentDescription = "imagen de fondo",
             contentScale = ContentScale.Crop,
             modifier = Modifier.fillMaxSize()
         )
         Box(
             modifier = Modifier
                 .background(color = Color(0xFF555F46))
                 .width(300.dp)
                 .height(500.dp)

         ){
             Column(
                 modifier = Modifier
                     .navigationBarsPadding()
                     .padding(24.dp)
                     .fillMaxSize(),
                 verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
                 horizontalAlignment = Alignment.CenterHorizontally
             ) {
                 Icon(
                     painter = painterResource(id = R.drawable.profile),
                     contentDescription = "Icono de Perfil",
                     modifier = Modifier.size(80.dp),
                     tint = Color.White
                 )
                 Texto()
                 Entrada(InicioSesion.Correo, keyboardActions = KeyboardActions(onNext = {
                     claveFocusRequester.requestFocus()
                 }))
                 Entrada(InicioSesion.Clave, keyboardActions = KeyboardActions(onDone = {
                     focusManager.clearFocus()
                 }), focusRequester = claveFocusRequester)
                 Button(
                     onClick = { },
                     modifier = Modifier.fillMaxWidth()
                 ) {
                     Text(
                         "Ingresar",
                         modifier = Modifier
                             .padding(vertical = 8.dp)
                     )
                 }
             }
         }
     }
 }

 @Composable
 fun Texto() {
     Text(
         text = "¡Bienvenidx a Torneos.UD!",
         fontWeight = FontWeight.Bold,
         color = Blanco
     )
 }

 sealed class InicioSesion(
     val label: String,
     val icon: ImageVector,
     val opcionesTeclado: KeyboardOptions,
     val visual: VisualTransformation
 ) {
     object Correo: InicioSesion(
         label = "Correo",
         icon = Icons.Default.Person,
         opcionesTeclado = KeyboardOptions(
             imeAction = ImeAction.Next,
             keyboardType = KeyboardType.Email
         ),
         visual = VisualTransformation.None
     )
     object Clave: InicioSesion(
         label = "Contraseña",
         icon = Icons.Default.Lock,
         opcionesTeclado = KeyboardOptions(
             imeAction = ImeAction.Done,
             keyboardType = KeyboardType.Password
         ),
         visual = PasswordVisualTransformation()
     )
 }

 @OptIn(ExperimentalMaterial3Api::class)
 @Composable
 fun Entrada(
     inicioSesion: InicioSesion,
     focusRequester: FocusRequester? = null,
     keyboardActions: KeyboardActions
 ) {
     var valor:String by remember { mutableStateOf("") }
     
     TextField(
         value = valor,
         onValueChange = { valor = it },
         modifier = Modifier
             .fillMaxWidth()
             .focusRequester(focusRequester ?: FocusRequester()),
         leadingIcon = {
             Icon(
                 inicioSesion.icon,
                 null
             )
         },
         label = {
             Text(text = inicioSesion.label)
         },
         shape = Shapes().small,
         colors = TextFieldDefaults.textFieldColors(
             containerColor = Blanco,
             unfocusedIndicatorColor = Color.Transparent,
             focusedIndicatorColor = Color.Transparent,
             disabledIndicatorColor = Color.Transparent
         ),
         singleLine = true,
         keyboardOptions = inicioSesion.opcionesTeclado,
         visualTransformation = inicioSesion.visual,
         keyboardActions = keyboardActions
     )
 }


@Preview(showSystemUi = true)
@Composable
fun PreviewComponent() {
    Proyecto_CampeonatoTheme {
        Login()
    }
}