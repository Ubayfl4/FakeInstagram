@file:kotlin.OptIn(ExperimentalMaterial3Api::class)

package com.example.aplicaciontipoinstagramubay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.FileUpload
import androidx.compose.material.icons.outlined.IosShare
import androidx.compose.material.icons.outlined.ModeComment
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicaciontipoinstagramubay.ui.theme.AplicacionTipoInstagramUbayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicacionTipoInstagramUbayTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    // A surface container using the 'background' color from the theme
    var pantalla = remember { mutableStateOf(true)}
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (pantalla.value) Login(cambio = { pantalla.value = false }) else Principal()
    }
}

@Composable
fun Login(cambio:  () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        )
    {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo de aplicacion",
        )
        var email = remember { mutableStateOf("")}
        OutlinedTextField(
            value = email.value,
            singleLine = true,
            onValueChange = {email.value = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = { Text(text = "Email") },
        )
        var password = remember {mutableStateOf("")}
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        OutlinedTextField(
            value = password.value,
            singleLine = true,
            onValueChange = {password.value = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            label = { Text(text = "Contraseña") },
            trailingIcon = {
                val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"
                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            }
        )
        Text(
            text = "¿Has olvidado la contraseña?",
            textDecoration = TextDecoration.Underline,
        )
        Button(
            onClick = { cambio() }
        ) {
            Text(text = "Login")
        }
    }
}


@Composable
fun Principal(){
    val imagenes = listOf(painterResource(id = R.drawable.persona1),
                          painterResource(id = R.drawable.persona2),
                          painterResource(id = R.drawable.persona3))
    Column() {
        Row(modifier = Modifier.padding(10.dp)) {
            for (imagen in imagenes) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.weight(1f)
                                       .shadow(elevation = 7.dp,
                                               shape = CircleShape)
                ) {
                    Image(
                        painter = imagen,
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .border(BorderStroke(2.dp, Color.Magenta), CircleShape)
                    )
                }
            }
        }

        val postImagen =  listOf(painterResource(id = R.drawable.persona4), painterResource(id = R.drawable.persona5))
        val postNombre = listOf("Jose Garcia", "Manuela Rodrigez")
        val postComent = listOf("Jgf hyj hj hyj yj rujky jrf  mry h jmugyr mkit ym kt jtmmj n nku  nuk knu nkunkuy  nuk kuny",
                                "sth   ato baoao gbqrog  hbapp tb baopo pap gbag apapr g taaat laasafghhh eerv  hw")

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (i in postImagen) {
                Box {
                    Image(
                        painter = i,
                        contentDescription = null,
                        modifier = Modifier.size(400.dp)
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.padding(5.dp)
                                           .weight(1f)
                    )
                    {
                        Icon(
                            Icons.Outlined.FavoriteBorder,
                            contentDescription = null,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            Icons.Outlined.ChatBubbleOutline,
                            contentDescription = null,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            Icons.Outlined.FileUpload,
                            contentDescription = null,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .weight(2f)
                    )
                    {
                        Icon(Icons.Outlined.BookmarkBorder, contentDescription = null)
                    }
                }
                Text(
                    text = "Jose Garcia",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
                Text(
                    text = "Jgf hyj hj hyj yj rujky jrf  mry h jmugyr mkit ym kt jtmmj n nku  nuk knu nkunkuy  nuk kuny",
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 15.dp)
                )
            }
        }
    }
}