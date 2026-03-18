package com.mmfsin.myfirstcomposeapp.components.model

import androidx.compose.ui.graphics.painter.Painter

data class DrawerItem(
    val name: String,
    val icon: Painter,
    val notification: Int
)
