package com.example.androidstudio_koala_template

import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.androidstudio_koala_template.ui.theme.AndroidStudioKoalaTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidStudioKoalaTemplateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var likes: Int by remember { mutableStateOf(997) }
    var selectedText: String by remember { mutableStateOf("") }
    var expanded: Boolean by remember { mutableStateOf(false) }
    val icons = listOf("Call", "ThumbUp", "Email", "AcountBox", "Build", "Check", "Create", "Delete", "FavoriteBorder", "LocationOn")
    var numMin: Int by remember { mutableStateOf(0) }
    var numMax: Int by remember { mutableStateOf(10) }
    var numMinString: String = numMin.toString()
    var numMaxString: String = numMax.toString()
    var valorNotis: Int by remember { mutableStateOf(0) }
    var valorNotisString : String = valorNotis.toString()

    Box(
        modifier = Modifier
            .fillMaxSize(1.0f)
            .padding(20.dp, 50.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(1.0f)
        ) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    // Afegir colors i detalls al desplegable:
                    .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
            ) {
                icons.forEach { icon ->
                    DropdownMenuItem(
                        text = { Text(text = icon) },
                        onClick = {
                            expanded = false
                            selectedText = icon
                        }
                    )
                }
            }

            Column (

            ){
                Column (

                ) {
                    TextField(
                        value = numMinString,
                        onValueChange = { numMinString = it },
                        label = {
                            Text(text = "Min")
                        }
                    )
                }

                Column (

                ) {
                    TextField(
                        value = numMaxString,
                        onValueChange = { numMaxString = it },
                        label = {
                            Text(text = "Min")
                        }
                    )
                }

                Spacer(modifier = Modifier)

                HorizontalDivider(
                    modifier = Modifier
                        .padding(0.dp, 10.dp),
                    thickness = 2.dp,
                    color = Color.Blue
                )

                Spacer(modifier = Modifier)

                BadgedBox(modifier = Modifier
                    .padding(20.dp, 0.dp),
                    badge = {
                        Badge(
                            containerColor = Color.Black,
                            contentColor = Color.White,
                            content = {
                                Text(
                                    text = valorNotisString
                                )
                            }
                        )
                    }
                ) {
                    Icon(
                        Icons.Default.ThumbUp,
                        contentDescription = "Icona"
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true
    , showSystemUi = true)
@Composable
fun GreetingPreview() {
    AndroidStudioKoalaTemplateTheme {
        Greeting("Android")
    }
}