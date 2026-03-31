package com.mmfsin.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mmfsin.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.mmfsin.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.mmfsin.myfirstcomposeapp.components.navigation.examples.LoginScreen
import com.mmfsin.myfirstcomposeapp.components.navigation.examples.SettingsScreen
import com.mmfsin.myfirstcomposeapp.components.navigation.examples.models.SettingModel
import com.mmfsin.myfirstcomposeapp.components.navigation.types.settingModelType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(
                navigateToHome = { navController.navigate(Home) })
        }

        composable<Home> {
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateDetail = { id -> navController.navigate(Detail(id = id, test = true)) })
        }

        composable<Detail> { data ->
            val detail: Detail = data.toRoute()
            DetailScreen(
                id = detail.id,
                navigateToSettings = { model -> navController.navigate(Settings(model)) }
            )
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingModel>() to settingModelType)) { data ->
            val settings = data.toRoute<Settings>()
            SettingsScreen(settings.settingModel)
        }
    }
}