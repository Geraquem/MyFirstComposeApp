package com.mmfsin.myfirstcomposeapp.components.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mmfsin.myfirstcomposeapp.R

@Composable
fun MyAnimatedContent(modifier: Modifier = Modifier) {
    var number: Int by remember { mutableIntStateOf(0) }
    Column(modifier.fillMaxSize()) {
        Button({ number++ }) {
            Text("Sumar")
        }
        Spacer(Modifier.height(32.dp))
        AnimatedContent(
            targetState = number
        ) { result ->
            when (result) {
                0 -> Box(Modifier.size(150.dp).background(Color.Red))
                1 -> Text("Holaaaa")
                else -> FloatingActionButton({})
                { Icon(painterResource(R.drawable.ic_person), "") }
            }
        }
    }
}