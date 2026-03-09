package com.mmfsin.myfirstcomposeapp.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyComplexLayout(modifier: Modifier) {
    Column(modifier) {
        Box(
            modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text("Ejemplo 1")
        }
        Row(modifier = Modifier.weight(1f).fillMaxWidth()) {
            Box(
                Modifier.background(Color.Red).fillMaxHeight().weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text("Ejemplo 2")
            }
            Box(
                Modifier.background(Color.Green).fillMaxHeight().weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text("Ejemplo 3")
            }
        }
        Box(
            modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text("Ejemplo 4")
        }
    }
}