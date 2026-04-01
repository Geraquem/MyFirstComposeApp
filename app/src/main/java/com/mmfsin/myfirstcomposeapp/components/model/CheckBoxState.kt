package com.mmfsin.myfirstcomposeapp.components.model

data class CheckBoxState(
    var id: String,
    var label: String,
    var check: Boolean = false,
)