package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun PVMyCard() {
    MyCard(Modifier)
}

@Composable
fun MyCard(modifier: Modifier = Modifier) {
    Card(
        modifier.padding(16.dp),
        shape = MaterialTheme.shapes.extraLarge,
        border = BorderStroke(2.dp, Color.Red),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp,
        )
    ) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(75.dp).clip(CircleShape).background(Color.Red))
            Column(Modifier.padding(horizontal = 16.dp)) {
                Text(
                    "Hola, bienvenido/a",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold
                )
                Text("Este es tu perfil y esta es tu descripción del perdil")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PVMyElevatedCard() {
    MyElevatedCard(Modifier)
}

@Composable
fun MyElevatedCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.padding(16.dp),
        shape = MaterialTheme.shapes.extraLarge,
    ) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(75.dp).clip(CircleShape).background(Color.Red))
            Column(Modifier.padding(horizontal = 16.dp)) {
                Text(
                    "Hola, bienvenido/a",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold
                )
                Text("Este es tu perfil y esta es tu descripción del perdil")
            }
        }
    }
}