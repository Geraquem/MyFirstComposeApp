package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("Parte 1")
        HorizontalDivider(thickness = 12.dp, color = Color.Red)
        Text("Parte 2")
        Spacer(Modifier.height(20.dp))
        Row() {
            Text("Parte 3")
            VerticalDivider(thickness = 12.dp, color = Color.Blue)
            Text("Parte 4")
        }
    }
}