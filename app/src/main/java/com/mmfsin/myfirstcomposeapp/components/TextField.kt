package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mmfsin.myfirstcomposeapp.R

@Composable
fun MyTextField(modifier: Modifier) {
    var value by remember { mutableStateOf("") }

    Column(modifier) {
        TextField(value = "hola ", onValueChange = {})
        Spacer(Modifier.padding(vertical = 8.dp))
        MyAdvancedTextField(value) { value = it }
        Spacer(Modifier.padding(vertical = 8.dp))
        MyPasswordTextField(value) { value = it }
        Spacer(Modifier.padding(vertical = 8.dp))
        MyOutlinedTextField(value) { value = it }
    }
}

@Composable
fun MyAdvancedTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value = value, onValueChange = { onValueChange(it) }, label = {
        Text("Introduce tu email")
    })
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden by remember { mutableStateOf(true) }
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Constraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            val icon = if (passwordHidden) R.drawable.ic_android_black_24dp
            else R.drawable.ic_launcher_background
            Image(
                painterResource(icon),
                contentDescription = null,
                Modifier.clickable { passwordHidden = !passwordHidden })
        }
    )
}

@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit) {
//    OutlinedTextField(value = value, onValueChange = { onValueChange(it) }, label = {
//        Text("Introduce tu email")
//    })

    BasicTextField(value = value, onValueChange = { onValueChange(it) })
}








