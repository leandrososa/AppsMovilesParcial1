package com.leandrososa.appsmovilesparcial1.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@Composable
fun LoginPage(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if(email.isEmpty() || password.isEmpty()){
                scope.launch {
                    snackbarHostState.showSnackbar("Por favor complete todos los campos")
                }
            }
            else if (email == "pedro@pe.com.ar" && password == "abc123"){
                val myName = "Pedro Pe"
                navController.navigate("home/$myName")
            } else {
                scope.launch {
                    snackbarHostState.showSnackbar("Usuario o contraseña incorrectos")
                }
            }
        }) {
            Text("Iniciar sesión")
        }

        SnackbarHost(hostState = snackbarHostState)
    }
}