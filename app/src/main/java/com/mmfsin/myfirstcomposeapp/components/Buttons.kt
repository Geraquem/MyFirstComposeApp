package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier) {
        Button(
            {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Red,
                disabledContainerColor = Color.Green,
                disabledContentColor = Color.Blue
            ),
            enabled = true
        ) {
            Text("Button")
        }
        OutlinedButton(
            {},
            enabled = true,
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Blue,
            )
        ) {
            Text("OutlinedButton")
        }

        TextButton({}) {
            Text(text = "TextButton")
        }

        ElevatedButton(
            {},
            elevation = ButtonDefaults.elevatedButtonElevation(
                pressedElevation = 150.dp,
            )
        ) {
            Text("ElevatedButton")
        }

        FilledTonalButton({}) {
            Text("Filled tonal")
        }
    }
}