package com.example.practicacompose3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicacompose3.ui.theme.PracticaCompose3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaCompose3Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    SimpleCompose()
                }
            }
        }
    }
}


@Composable
fun SimpleCompose() {
    var textFielValue by remember {
        mutableStateOf("")
    }
    var textValue by remember {
        mutableStateOf("Title App Desing")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id =R.drawable.foto ),
            contentDescription = "Foto de Prueba",
            contentScale = ContentScale.FillWidth
        )
        Text(
            modifier=Modifier.fillMaxWidth(),
            text = textValue,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        TextField(
            value = textFielValue,
            onValueChange ={
                           nuevoTexto -> textFielValue=nuevoTexto
            },
            label = {
                Text(text = "Inserte Texto aqui")
            },
           leadingIcon = {
               Icon(
                   modifier=Modifier.size(24.dp),
                   painter = painterResource(id = R.drawable.ic_android),
                   contentDescription = "icono textfiel"
               )
           }
        )
        Button(onClick = {
            textValue= textFielValue
            textFielValue=""
        }
        ) {
            Text(text = "Aceptar")
        }
    }

}



@Preview(name = "Implementando Diseño",showSystemUi = true, device = Devices.DEFAULT)
@Composable
fun DefaultPreview() {
    PracticaCompose3Theme {
        SimpleCompose()
    }
}