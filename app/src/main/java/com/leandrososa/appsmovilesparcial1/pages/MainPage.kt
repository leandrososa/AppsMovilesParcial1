package com.leandrososa.appsmovilesparcial1.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leandrososa.appsmovilesparcial1.ui.theme.AppsMovilesParcial1Theme

@Composable
fun MainPage(modifier: Modifier = Modifier) {

    val navHostController = rememberNavController()

    Scaffold(
        modifier = modifier,
        topBar = { MainTopAppBar() }

    ) {
        MainNavHost(
            modifier = Modifier.padding(it),
            navHostController = navHostController
        )
    }
}

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navHostController : NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginPage(navHostController)
        }
        composable("home") {
            HomePage()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(){
    TopAppBar(
        title = {
            Text(text = "Bienvenido")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AppsMovilesParcial1Theme {
        MainPage()
    }
}