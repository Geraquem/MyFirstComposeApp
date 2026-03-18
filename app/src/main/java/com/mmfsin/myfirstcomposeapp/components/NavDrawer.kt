package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mmfsin.myfirstcomposeapp.R
import com.mmfsin.myfirstcomposeapp.components.model.DrawerItem
import kotlinx.coroutines.launch

@Composable
fun MyNavigationDrawer(drawerState: DrawerState, content: @Composable () -> Unit) {
    val scope = rememberCoroutineScope()
    val items = listOf(
        DrawerItem("Ejemplito 1", icon = painterResource(R.drawable.ic_person), notification = 0),
        DrawerItem(
            "Ejemplito 2",
            icon = painterResource(R.drawable.ic_android_black_24dp),
            notification = 2
        ),
        DrawerItem("Ejemplito 3", icon = painterResource(R.drawable.ic_person), notification = 5),
        DrawerItem("Ejemplito 4", icon = painterResource(R.drawable.ic_person), notification = 4),
        DrawerItem("Ejemplito 5", icon = painterResource(R.drawable.ic_person), notification = 14),
        DrawerItem(
            "Ejemplito 6",
            icon = painterResource(R.drawable.ic_person),
            notification = 654354324
        ),
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(topEnd = 50.dp)
            ) {
                Spacer(Modifier.height(64.dp))
                items.forEachIndexed { i, item ->
                    MyDrawerItem(item, isSelected = i == selectedIndex) {
                        selectedIndex = i
                        scope.launch { drawerState.close() }
                    }
                }
            }
        },
    ) { content() }
}

@Composable
fun MyDrawerItem(item: DrawerItem, isSelected: Boolean, onSelected: () -> Unit) {
    NavigationDrawerItem(
        label = { Text(item.name) },
        selected = isSelected,
        icon = { Icon(painter = item.icon, "") },
        badge = { if (item.notification > 0) Badge { Text(item.notification.toString()) } },
        shape = RoundedCornerShape(0),
        onClick = { onSelected() }
    )
}