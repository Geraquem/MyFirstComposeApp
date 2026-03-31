package com.mmfsin.myfirstcomposeapp.components.navigation

import com.mmfsin.myfirstcomposeapp.components.navigation.examples.models.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String, val test: Boolean)

@Serializable
data class Settings(val settingModel: SettingModel)