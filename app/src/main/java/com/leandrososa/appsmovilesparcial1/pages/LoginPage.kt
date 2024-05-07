package com.leandrososa.appsmovilesparcial1.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "User Icon",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
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

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Leandro Sosa, Parcial 1 de Aplicaciones Móviles",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(32.dp))

            SnackbarHost(hostState = snackbarHostState)
        }
    }
}