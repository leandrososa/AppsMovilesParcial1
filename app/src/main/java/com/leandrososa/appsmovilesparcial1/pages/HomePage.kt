package com.leandrososa.appsmovilesparcial1.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.leandrososa.appsmovilesparcial1.ui.theme.AppsMovilesParcial1Theme

@Composable
fun HomePage(message: String?) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Welcome", style = MaterialTheme.typography.headlineLarge)
            if (message != null) {
                Text(text = message)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    AppsMovilesParcial1Theme {
        HomePage("Pedro Pe")
    }
}