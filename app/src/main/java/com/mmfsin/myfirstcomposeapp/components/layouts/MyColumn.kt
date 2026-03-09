package com.mmfsin.myfirstcomposeapp.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyColumn(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
        Text(text = "hola 1", modifier = Modifier.background(Color.Red))
        Text(text = "hola 2", modifier = Modifier.background(Color.Cyan))
        Text(text = "hola 3", modifier = Modifier.background(Color.Yellow))
        Text(text = "hola 4", modifier = Modifier.background(Color.Blue))
    }
}