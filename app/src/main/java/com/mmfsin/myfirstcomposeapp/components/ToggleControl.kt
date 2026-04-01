package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmfsin.myfirstcomposeapp.R
import com.mmfsin.myfirstcomposeapp.components.state.CheckBoxState

@Preview(showBackground = true)
@Composable
fun PVMySwitch() {
    MySwitch(Modifier)
}

@Composable
fun MySwitch(modifier: Modifier) {
    Column(modifier) {
        var state by remember { mutableStateOf(true) }
        Switch(
            checked = state,
            onCheckedChange = { state = it },
            thumbContent = {
                Icon(
                    painterResource(R.drawable.ic_android_black_24dp),
                    contentDescription = null
                )
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Black,
                checkedTrackColor = Color.Blue,
                checkedBorderColor = Color.Cyan,
                checkedIconColor = Color.Blue,
            )
        )

        Checkbox(
            checked = state,
            { state = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue,
                uncheckedColor = Color.Blue,
                checkmarkColor = Color.Cyan,
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PVCheckBoxes() {
    ParentCheckBoxes(Modifier)
}

@Composable
fun ParentCheckBoxes(modifier: Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckBoxState("terms", "Aceptar TyC"),
                CheckBoxState("newsletter", "Recibir Noticias", true),
                CheckBoxState("updates", "Recibir updates")
            )
        )
    }
    Column(modifier.padding(horizontal = 16.dp)) {
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if (it.id == myState.id) it.copy(check = !it.check) else it
                }
            }
        }
    }
}

@Composable
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onStateChanged: (CheckBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onStateChanged(checkBoxState) }) {
        Checkbox(
            checked = checkBoxState.check,
            onCheckedChange = { onStateChanged(checkBoxState) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Blue,
                uncheckedColor = Color.Blue,
                checkmarkColor = Color.Cyan,
            )
        )

        Text(checkBoxState.label)
    }
}

@Composable
fun TriStateCheckBox(modifier: Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(
                parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    child1 = newState
                    child2 = child1
                }
            )
            Text("Seleccionar todo")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Checkbox(child1, { child1 = it })
            Text("Ejemplo 2")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Checkbox(child2, { child2 = it })
            Text("Ejemplo 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PVMyRadioButton() {
    MyRadioButton(Modifier.padding(horizontal = 16.dp))
}

@Composable
fun MyRadioButton(modifier: Modifier) {
    var state by remember { mutableStateOf(false) }

    Column(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Ejemplo 1")
            RadioButton(
                selected = state,
                onClick = { state = true }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PVMyRadioButtonList() {
    MyRadioButtonList(Modifier)
}

@Composable
fun MyRadioButtonList(modifier: Modifier) {
    var selectedName by remember { mutableStateOf("") }
    Column(modifier.padding(0.dp)) {
        RadioButtonComponent("Nombre 1", selectedName) { selectedName = it }
        RadioButtonComponent("Nombre 2", selectedName) { selectedName = it }
        RadioButtonComponent("Nombre 3", selectedName) { selectedName = it }
        RadioButtonComponent("Nombre 4", selectedName) { selectedName = it }
    }
}

@Composable
fun RadioButtonComponent(name: String, selectedName: String, onItemSelected: (String) -> Unit) {
    Row(
        modifier = Modifier.clickable { onItemSelected(name) }.padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = name == selectedName, onClick = { onItemSelected(name) })
        Text(text = name)
    }
}



















