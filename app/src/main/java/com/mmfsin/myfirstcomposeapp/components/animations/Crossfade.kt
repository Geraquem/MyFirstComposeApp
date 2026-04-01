package com.mmfsin.myfirstcomposeapp.components.animations

import android.widget.TableRow
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.mmfsin.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.mmfsin.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.mmfsin.myfirstcomposeapp.components.navigation.examples.LoginScreen

@Composable
fun MyCrossFade(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("Home") }
    Column(modifier) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                "Home",
                Modifier.weight(1f).clickable { currentScreen = "Home" },
                textAlign = TextAlign.Center
            )
            Text(
                "Detail",
                Modifier.weight(1f).clickable { currentScreen = "Detail" },
                textAlign = TextAlign.Center
            )
            Text(
                "Login",
                Modifier.weight(1f).clickable { currentScreen = "Login" },
                textAlign = TextAlign.Center
            )
        }

        Crossfade(targetState = currentScreen) { screen ->
            when (screen) {
                "Home" -> HomeScreen(navigateBack = {}, navigateDetail = {})
                "Detail" -> DetailScreen(id = "", navigateToSettings = {})
                "Login" -> LoginScreen(navigateToHome = {})
            }
        }
    }
}