package com.mmfsin.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.mmfsin.myfirstcomposeapp.components.navigation.examples.models.SettingModel

@Composable
fun SettingsScreen(settingModel: SettingModel, navigateToHome: () -> Unit) {
    Column(
        Modifier.fillMaxSize().background(Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))

        Text(
            text = "Settings Screen id: ${settingModel.id} and darkmode: ${settingModel.darkMode}",
            fontSize = 30.sp
        )
        Spacer(Modifier.weight(1f))
        Button({ navigateToHome() }) {
            Text("Volver al inicio")
        }
        Spacer(Modifier.weight(1f))
    }
}