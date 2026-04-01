@file:OptIn(ExperimentalMaterial3Api::class)

package com.mmfsin.myfirstcomposeapp.components

import android.icu.util.Calendar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.mmfsin.myfirstcomposeapp.R
import com.mmfsin.myfirstcomposeapp.components.model.PokemonCombat

@Preview(showBackground = true)
@Composable
fun PVMyAlertDialog() {
    MyAlertDialog(Modifier)
}

@Composable
fun MyAlertDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = { Button(onClick = { showDialog = false }) { Text("Confirmar") } },
            text = { Text("Hola buenos días soy una alerta") },
            shape = RoundedCornerShape(18),
            dismissButton = { TextButton(onClick = { showDialog = false }) { Text("Cancelar") } },
            title = { Text("Titulo de la Alerta") },
            icon = { Icon(painterResource(R.drawable.ic_person), "") },
            properties = DialogProperties(
                dismissOnBackPress = true, dismissOnClickOutside = true
            )
        )
    }

    Box(contentAlignment = Alignment.Center) {
        Button(onClick = { showDialog != showDialog }) {
            Text("Open Alert dialog")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PVMyDateDialog() {
    MyDateDialog(Modifier)
}

@Composable
fun MyDateDialog(modifier: Modifier) {
    var showDialog by remember { mutableStateOf(true) }

    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_MONTH, 1)
    calendar.set(Calendar.MONTH, Calendar.JANUARY)

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        initialDisplayMode = DisplayMode.Picker,
        initialDisplayedMonthMillis = calendar.timeInMillis,
        yearRange = 2024..2026
    )

    if (showDialog) {
        DatePickerDialog(
            shape = RoundedCornerShape(10),
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    val result = datePickerState.selectedDateMillis

                    result?.let {
                        val newCalendar = Calendar.getInstance().apply { timeInMillis = result }
                        val day = newCalendar.get(Calendar.DAY_OF_MONTH)
                        val month = newCalendar.get(Calendar.MONTH) + 1
                        val year = newCalendar.get(Calendar.YEAR)
                        println("Selected Date ---> ${day}/${month}/${year}")
                    }
                }) { Text("Confirmar") }
            }) {
            DatePicker(state = datePickerState)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PVMyTimePicker() {
    MyTimePicker(Modifier)
}


@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {
    val timePickerState = rememberTimePickerState(
        initialHour = 14,
        initialMinute = 50,
        is24Hour = true
    )

    TimePickerDialog(
        onDismissRequest = {},
        confirmButton = { TextButton(onClick = { }) { Text("Confirmar") } },
        title = { Text("Confirmar") },
        shape = RoundedCornerShape(10)
    ) {
        TimePicker(state = timePickerState)
    }
}

@Preview(showBackground = true)
@Composable
fun PVMyCustomDialog() {
    MyCustomDialog(PokemonCombat("Pikachu", "Charmander"), true) {}
}

@Composable
fun MyCustomDialog(
    pokemonCombat: PokemonCombat,
    showDialog: Boolean, onDismiss: () -> Unit
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = { onDismiss() }) {
            Column(Modifier.fillMaxWidth().background(Color.Blue, shape = RoundedCornerShape(10))) {
                Row() {
                    Text(text = pokemonCombat.pokemonA)
                    Text(text = "VS")
                    Text(text = pokemonCombat.pokemonB)
                }
                Button(onClick = { onDismiss() }) { Text("A luchar") }
            }
        }
    }
}



















