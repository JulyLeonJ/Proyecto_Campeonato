 package com.julyleon.proyecto_campeonato

import android.content.res.Configuration
import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.julyleon.proyecto_campeonato.ui.theme.Blanco
import com.julyleon.proyecto_campeonato.ui.theme.Iconos
import com.julyleon.proyecto_campeonato.ui.theme.Proyecto_CampeonatoTheme

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


                 Titulo("¡Bievenidx a Torneos.UD!")
                 TipoUsuario()
                 Entrada(InicioSesion.Correo, keyboardActions = KeyboardActions(onNext = {
                     claveFocusRequester.requestFocus()
                 }))
                 Entrada(InicioSesion.Clave, keyboardActions = KeyboardActions(onDone = {
                     focusManager.clearFocus()
                 }), focusRequester = claveFocusRequester)
                 BotonPrincipal(titulo = "Ingresar")
                 TextoBottom("¿No tienes cuenta? ", "Creala" )



                 }
             }
         }
     }

 
 @Composable
 fun BotonPrincipal(titulo: String) {
     Button(
         onClick = { },
         modifier = Modifier
             .fillMaxWidth(),
         colors = ButtonDefaults.buttonColors(
             containerColor = Iconos
         )
     ) {
         Text(
             titulo,
             modifier = Modifier
                 .padding(vertical = 8.dp)
         )
     }
 }

 @Composable
 fun TipoUsuario() {
     val options = arrayOf(
         Opciones(
             "Organizador"
         ),
         Opciones(
             "Jugador"
         )
     )

     ToggleButton(
         options = options,
         type = TipoSeleccion.SINGLE,
         modifier = Modifier
             .padding(end = 4.dp)
             .background(Blanco),
         onClick = {  }
     )
 }

 enum class TipoSeleccion {
     NONE, SINGLE, MULTIPLE
 }

 data class Opciones(
     val texto: String
 )

 @Composable
 fun SelectionItem(
     option: Opciones,
     selected: Boolean,
     onClick: (option: Opciones) -> Unit = {}
 ){
     Button(
         onClick = { onClick(option) },
         colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Iconos else Blanco
         ),
         shape = RoundedCornerShape(0),
         elevation = ButtonDefaults.buttonElevation(0.dp, 0.dp),
         contentPadding = PaddingValues(0.dp),
         modifier = Modifier.padding(14.dp, 0.dp)
     ){
         Row (
             modifier = Modifier.padding(0.dp),
             verticalAlignment = Alignment.CenterVertically
         ) {
             Text(
                 text = option.texto,
                 color = if (selected) Blanco else Iconos,
                 modifier = Modifier.padding(0.dp)
             )
         }
     }
 }

 @Composable
 fun ToggleButton(
     options: Array<Opciones>,
     modifier: Modifier = Modifier,
     type: TipoSeleccion = TipoSeleccion.SINGLE,
     onClick: (selectedOptionS: Array<Opciones>) -> Unit = {}
 ){
     val estado = remember { mutableStateMapOf<String, Opciones>() }

     OutlinedButton(
         onClick = { /*TODO*/ },
         border = BorderStroke(1.dp, Blanco),
         shape = RoundedCornerShape(0),
         colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.LightGray),
         contentPadding = PaddingValues(0.dp, 0.dp),
         modifier = modifier
             .padding(0.dp)
             .height(30.dp)
     ) {
         if (options.isEmpty()) {
             return@OutlinedButton
         }

         val onItemClick: (option: Opciones) -> Unit = { option ->  
             if (type == TipoSeleccion.SINGLE) {
                 options.forEach {
                     val key = it.texto
                     if (key == option.texto) {
                         estado[key] = option
                     } else {
                         estado.remove(key)
                     }
                 }
             } else {
                 val key = option.texto
                 if (!estado.contains(key)) {
                     estado[key] = option
                 } else {
                     estado.remove(key)
                 }
             }
             onClick(estado.values.toTypedArray())
         }

         if (options.size == 1) {
             val option = options.first()

             SelectionItem(
                 option = option,
                 selected = estado.contains(option.texto),
                 onClick = onItemClick
             )
             return@OutlinedButton
         }

         val first = options.first()
         val last = options.last()
         val middle = options.slice(1..options.size - 2)

         SelectionItem(
             option = first,
             selected = estado.contains(first.texto),
             onClick = onItemClick
         )

         Divider(modifier = Modifier
             .fillMaxHeight()
             .width(2.dp)
         )

         middle.map { option ->
             SelectionItem(
                 option = option,
                 selected = estado.contains(option.texto),
                 onClick = onItemClick
             )
             Divider(modifier = Modifier
                 .fillMaxHeight()
                 .width(2.dp)
             )
         }
         SelectionItem(
             option = last,
             selected = estado.contains(last.texto),
             onClick = onItemClick
         )
     }

 }

 @Composable
 fun Titulo(texto: String) {
     Text(
         text = texto,
         fontWeight = FontWeight.Bold,
         style = MaterialTheme.typography.titleLarge,
         color = Blanco
     )
 }
 @Composable
 fun TextoBottom(texto: String, boton: String) {
     Row{
         Text(
             text = texto,
             fontWeight = FontWeight.Normal,
             color = Blanco
         )
         Text(
             text = boton,
             fontWeight = FontWeight.Bold,
             textDecoration = TextDecoration.Underline,
             color = Iconos
         )
     }
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