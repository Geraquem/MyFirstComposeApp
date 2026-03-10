package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier) {
        Text("hola")
        Text("hola")
        Text("hola")
        Text("hola")
        Text("hola", color = Color.Blue)
    }
}