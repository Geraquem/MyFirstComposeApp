package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mmfsin.myfirstcomposeapp.R
import com.mmfsin.myfirstcomposeapp.components.model.NavItem

@Composable
fun MyBottomNavBar() {
    val navItems = listOf(
        NavItem(name = "Home", icon = painterResource(R.drawable.ic_person)),
        NavItem(name = "Fav", icon = painterResource(R.drawable.ic_android_black_24dp)),
        NavItem(name = "Profile", icon = painterResource(R.drawable.ic_person)),
    )

    var selectedIndex by remember { mutableIntStateOf(2) }

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Red,
    ) {
        navItems.forEachIndexed { i, item ->
            MyNavItem(item, i == selectedIndex) {
                if (it == item.name) selectedIndex = i
            }
        }
    }
}

@Composable
fun RowScope.MyNavItem(navItem: NavItem, isSelected: Boolean, select: (String) -> Unit) {
    NavigationBarItem(
        selected = isSelected,
        onClick = { select(navItem.name) },
        icon = { Icon(painter = navItem.icon, contentDescription = navItem.name) },
        label = { Text(text = navItem.name) },
        alwaysShowLabel = false
    )
}