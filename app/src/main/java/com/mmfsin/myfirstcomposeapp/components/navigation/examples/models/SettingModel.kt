package com.mmfsin.myfirstcomposeapp.components.navigation.examples.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class SettingModel(
    val id: Int,
    val darkMode: Boolean
) : Parcelable
