package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.mmfsin.myfirstcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropDownMenu(modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selection by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selection,
            onValueChange = {},
            label = { Text("Idioma") },
            readOnly = true,
            modifier = Modifier.menuAnchor().fillMaxWidth(),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Opción 1") },
                onClick = {
                    expanded = false
                    selection = "Opción 1"
                }
            )
            DropdownMenuItem(
                text = { Text("Opción 2") },
                onClick = {
                    expanded = false
                    selection = "Opción 2"
                }
            )
            DropdownMenuItem(
                text = { Text("Opción 3") },
                onClick = {
                    expanded = false
                    selection = "Opción 3"
                }
            )
            DropdownMenuItem(
                text = { Text("Opción 4") },
                onClick = {
                    expanded = false
                    selection = "Opción 4"
                }
            )
        }
    }
}

@Composable
fun MyDropDownMenu(modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier) {
        Button(onClick = { expanded = true }) {
            Text(text = "Ver opciones")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(100.dp, 16.dp),
            properties = PopupProperties(
                dismissOnClickOutside = false
            )
        ) {
            DropdownMenuItem(text = { Text("Opción 1") }, { expanded = false })
            DropdownMenuItem(text = { Text("Opción 2") }, { expanded = false })
            DropdownMenuItem(text = { Text("Opción 3") }, { expanded = false })
            DropdownMenuItem(text = { Text("Opción 4") }, { expanded = false })
        }
    }
}

@Composable
fun MyDropDownItem(modifier: Modifier) {
    Column(modifier) {
        DropdownMenuItem(
            modifier = Modifier.fillMaxWidth(),
            text = { Text("Ejemplo 1") },
            onClick = {},
            leadingIcon = {
                Icon(
                    painterResource(R.drawable.ic_android_black_24dp),
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    painterResource(R.drawable.ic_android_black_24dp),
                    contentDescription = null
                )
            },
            contentPadding = PaddingValues(24.dp),

            )
    }
}