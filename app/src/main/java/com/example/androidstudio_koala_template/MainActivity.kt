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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var subscribers: Int by remember { mutableStateOf(12) }
    var notifications: Int by remember { mutableStateOf(204) }
    var selectedText: String by remember { mutableStateOf("") }
    var expanded: Boolean by remember { mutableStateOf(false) }
    val hobbies = listOf("Play music", "Practice sport", "Programming", "Reading", "Other")

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
                hobbies.forEach { hobby ->
                    DropdownMenuItem(
                        text = { Text(text = hobby) },
                        onClick = {
                            expanded = false
                            selectedText = hobby
                        }
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(0.dp, 10.dp),
                thickness = 2.dp,
                color = Color.Blue
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(1.0f)
            ) {
                BadgedBox(modifier = Modifier
                    .padding(20.dp, 0.dp),
                    badge = {
                        Badge(
                            containerColor = Color.Black,
                            contentColor = Color.White,
                            content = {
                                Text(
                                    text =
                                    if (likes > 999) {
                                        "999+"
                                    } else {
                                        "$likes"
                                    }
                                )
                            }
                        )
                    }
                ) {
                    Icon(
                        Icons.Default.ThumbUp,
                        contentDescription = "Likes"
                    )
                }

                BadgedBox(modifier = Modifier
                    .padding(20.dp, 0.dp),
                    badge = {
                        Badge(
                            containerColor = Color.Blue,
                            contentColor = Color.Cyan,
                            content = {
                                Text("$subscribers")
                            }
                        )
                    }
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Subscribe"
                    )
                }

                BadgedBox(modifier = Modifier
                    .padding(20.dp, 0.dp),
                    badge = {
                        Badge(
                            containerColor = Color.DarkGray,
                            contentColor = Color.LightGray,
                            content = {
                                Text("$notifications")
                            }
                        )
                    }
                ) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notificacions"
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(0.dp, 10.dp),
                thickness = 5.dp,
                color = Color.LightGray
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(1.0f)
            ) {
                Button(onClick = { likes++ }) {
                    Text("Like")
                }

                Button(onClick = { subscribers++ }) {
                    Text("Subscribe")
                }

                Button(onClick = { notifications++ }) {
                    Text("Notifications")
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