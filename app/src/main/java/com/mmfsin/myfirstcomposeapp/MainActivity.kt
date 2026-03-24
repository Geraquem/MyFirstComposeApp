package com.mmfsin.myfirstcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mmfsin.myfirstcomposeapp.components.MyBottomNavBar
import com.mmfsin.myfirstcomposeapp.components.MyCustomDialog
import com.mmfsin.myfirstcomposeapp.components.MyFloatingActionButton
import com.mmfsin.myfirstcomposeapp.components.MyNavigationDrawer
import com.mmfsin.myfirstcomposeapp.components.MyTopAppBar
import com.mmfsin.myfirstcomposeapp.components.model.PokemonCombat
import com.mmfsin.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
//                ScaffoldExample()

                Scaffold { innerPadding ->
//                    MyTimePicker(modifier = Modifier.padding(innerPadding))

                    var showDialog by remember { mutableStateOf(true) }
                    val pokemonCombat = PokemonCombat("Pikachu", "Gengar")

                    MyCustomDialog(
                        pokemonCombat = pokemonCombat,
                        showDialog = showDialog
                    ) {
                        showDialog = false
                    }
                }
            }
        }
    }

    @Composable
    fun ScaffoldExample() {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        MyNavigationDrawer(drawerState) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                floatingActionButton = {
                    MyFloatingActionButton {
                        Log.i("FloatingButtonClick", "Clickado")
                    }
                },
                floatingActionButtonPosition = FabPosition.Center,
                bottomBar = { MyBottomNavBar() },

                ) { innerPadding ->
                Box(
                    modifier = Modifier.fillMaxSize().padding(innerPadding)
                        .background(Color.Cyan),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Esta es mi screen", modifier = Modifier.clickable {
                        scope.launch {
                            val result = snackbarHostState.showSnackbar(
                                "Hola desde Compose",
                                actionLabel = "Deshacer",
                                duration = SnackbarDuration.Short
                            )
                            val text = if (result == SnackbarResult.ActionPerformed) {
                                "Sí pulsó deshacer"
                            } else "NO pulsó deshacer"
                            Log.i("Snackbar", text)
                        }
                    })
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyFirstComposeAppTheme {
            Greeting("Android")
        }
    }
}