package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PVMyProgressBar() {
    MyProgressBar(Modifier)
}

@Composable
fun MyProgressBar(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            Modifier.size(50.dp),
            strokeWidth = 8.dp,
            color = Color.Green,
            trackColor = Color.Red,
            gapSize = 8.dp,
            strokeCap = StrokeCap.Round
        )
        Spacer(Modifier.heightIn(24.dp))
        LinearProgressIndicator(
            trackColor = Color.Transparent, strokeCap = StrokeCap.Round
        )
        Spacer(Modifier.heightIn(24.dp))

        var progress by remember { mutableFloatStateOf(0.5f) }
        val animatedProgress by animateFloatAsState(targetValue = progress)
        var isLoading by remember { mutableStateOf(false) }

        if (isLoading) {
            CircularProgressIndicator(
                progress = { animatedProgress },
                Modifier.size(80.dp),
                strokeWidth = 8.dp,
                gapSize = 8.dp,
                strokeCap = StrokeCap.Round
            )
        }
        Spacer(Modifier.heightIn(12.dp))

        Row {
            Button({
                progress = if (progress > 1f) 1f else (progress + 0.1f)
            }) { Text("<-") }

            Spacer(Modifier.width(24.dp))

            Button({ progress = if (progress < 0f) 0f else (progress - 0.1f) })
            { Text("->") }
        }

        Spacer(Modifier.height(24.dp))

        Button({ isLoading = !isLoading }) { Text("Visibility") }
    }
}