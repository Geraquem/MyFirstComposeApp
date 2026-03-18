@file:OptIn(ExperimentalMaterial3Api::class)

package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mmfsin.myfirstcomposeapp.R

@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text("My app") },
        navigationIcon = {
            Icon(
                modifier = Modifier.padding(horizontal = 8.dp),
                painter = painterResource(R.drawable.ic_android_black_24dp),
                contentDescription = null
            )
        },
        actions = {
            Row {
                Icon(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    painter = painterResource(R.drawable.ic_android_black_24dp),
                    contentDescription = null
                )
                Icon(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    painter = painterResource(R.drawable.ic_android_black_24dp),
                    contentDescription = null
                )
            }
        }
    )
}