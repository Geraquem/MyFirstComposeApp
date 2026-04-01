@file:OptIn(ExperimentalMaterial3Api::class)

package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PVMySlider() {
    MySlider(Modifier)
}

@Composable
fun MySlider(modifier: Modifier) {
    var myValue by remember { mutableFloatStateOf(0f) }
    var text by remember { mutableStateOf("") }
    Column(modifier.padding(12.dp)) {
        Slider(
            value = myValue,
            onValueChange = { myValue = it },
            onValueChangeFinished = { text = "Fin" }
        )
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(myValue.toString())
            Text(text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PVMyAdvancedSlider() {
    AdvancedSlider(Modifier)
}

@Composable
fun AdvancedSlider(modifier: Modifier) {
    val state = remember {
        SliderState(
            value = 5f,
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = {}
        )
    }
    Column(modifier.padding(24.dp)) {
        Slider(state)
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(state.value.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PVMyRangeSlider() {
    MyRangeSlider(Modifier)
}

@Composable
fun MyRangeSlider(modifier: Modifier) {
    val state = remember {
        RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 6f,
            valueRange = 0f..10f,
            onValueChangeFinished = {},
            steps = 2
        )
    }

    Column(modifier.padding(12.dp)) {
        RangeSlider(state = state)
    }
}