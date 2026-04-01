package com.mmfsin.myfirstcomposeapp.components.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun PVMyState() {
    MyState(Modifier)
}

@Composable
fun MyState(modifier: Modifier) {
    var number by rememberSaveable { mutableIntStateOf(0) }
    Column(modifier = modifier) {
        StateExample1(number, updateNumber = { number++ })
        StateExample2(number, updateNumber = { number++ })
    }
}

@Composable
fun StateExample1(number: Int, updateNumber: () -> Unit) {
    Text("Púlsame: $number", modifier = Modifier.clickable { updateNumber() })
}

@Composable
fun StateExample2(number: Int, updateNumber: () -> Unit) {
    Text("Púlsame: $number", modifier = Modifier.clickable { updateNumber() })
}