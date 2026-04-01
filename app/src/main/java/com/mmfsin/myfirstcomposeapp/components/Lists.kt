package com.mmfsin.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mmfsin.myfirstcomposeapp.R
import kotlinx.coroutines.launch
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun PVMyBasicList() {
    MyBasicList(Modifier) {}
}

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClick: (String) -> Unit) {
    val names = listOf("Nombre 1", "Nombre 2", "Nombre 3")

    LazyColumn(modifier.padding(24.dp)) {
//        for (i in 1..100) {
//            item { Text(text = "Nombre $i") }
//        }

        items(names) { Text(text = it, Modifier.clickable { onItemClick(it) }) }
    }

    LazyRow() { }
}

@Preview(showBackground = true)
@Composable
fun PVMyAdvancedList() {
    MyAdvancedList(Modifier)
}

@Composable
fun MyAdvancedList(modifier: Modifier = Modifier) {
    var items by remember { mutableStateOf(List(10) { "Item $it" }) }

    LazyColumn(modifier) {
        item {
            Button({
                items = items.toMutableList().apply {
                    add(0, "Item ${items.size}")
                }
            }) { Text("Añadir item") }
        }
        itemsIndexed(items, key = { _, item -> item }) { i, item ->
            Row(Modifier.padding(12.dp)) {
                Text(text = item)
                Spacer(Modifier.weight(1f).background(Color.Red))
                TextButton(onClick = {
                    items.toMutableList().apply {
                        remove(item)
                        println("------------------------------- borrado $item")
                    }
                }) { Text("Borrar") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PVMyScrollList() {
    MyScrollList(Modifier)
}

@Composable
fun MyScrollList(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showButton by remember { derivedStateOf { listState.firstVisibleItemIndex > 5 } }

    Box(modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
        LazyColumn(state = listState) {
            items(100) { Text(text = "Item: $it", Modifier.fillMaxWidth().padding(16.dp)) }
        }

        if (showButton) {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
//                    listState.animateScrollToItem(0)
                    listState.scrollToItem(0)
                }
            }, Modifier.padding(16.dp)) {
                Icon(painterResource(R.drawable.ic_person), " ")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PVMyGridList() {
    MyGridList(Modifier)
}

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    val numbers = remember { mutableStateOf(List(50) { Random.nextInt(0, 6) }) }
    val colors = listOf(
        Color.Red, Color.Green, Color.Blue, Color.Cyan, Color.Magenta, Color.DarkGray
    )

//    LazyHorizontalGrid(
//        rows = GridCells.FixedSize(3),
    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp),
        modifier = modifier.padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(numbers.value) { randomNumber ->
            Box(
                modifier = Modifier.background(colors[randomNumber]).height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = randomNumber.toString(), color = Color.White, fontSize = 28.sp)
            }

        }
    }
}



















