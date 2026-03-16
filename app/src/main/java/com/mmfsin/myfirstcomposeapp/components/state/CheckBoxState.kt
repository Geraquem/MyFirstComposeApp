package com.mmfsin.myfirstcomposeapp.components.state

data class CheckBoxState(
    var id: String,
    var label: String,
    var check: Boolean = false,
)