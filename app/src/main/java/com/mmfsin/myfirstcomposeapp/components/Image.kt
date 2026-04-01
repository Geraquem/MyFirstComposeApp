package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.mmfsin.myfirstcomposeapp.R

@Preview(showBackground = true)
@Composable
fun PVMyImage() {
    MyImage(Modifier)
}

@Composable
fun MyImage(modifier: Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.ic_android_black_24dp), contentDescription = null,
            contentScale = ContentScale.FillHeight
        )

        AsyncImage(
            model = "https://media.revistavanityfair.es/photos/686bad6030be280fbf3eebe6/4:3/w_4216,h_3162,c_limit/GettyImages-1693596089.jpg",
            contentDescription = null,
            onSuccess = {
                println("Success")
            },
            onError = {
                println("Error")
            }
        )
    }
}