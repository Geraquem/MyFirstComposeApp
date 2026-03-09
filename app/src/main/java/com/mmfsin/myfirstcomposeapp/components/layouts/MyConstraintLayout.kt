package com.mmfsin.myfirstcomposeapp.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyBasicConstraintLayout(modifier: Modifier) {
    Column(
        modifier.padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Box(Modifier.size(175.dp).weight(2f).background(Color.Cyan))
            Box(
                Modifier.weight(1f).height(175.dp), contentAlignment = Alignment.Center
            ) {
                Box(Modifier.size(75.dp).background(Color.Black))
            }
            Box(Modifier.size(175.dp).weight(2f).background(Color.DarkGray))
        }
        ConstraintLayout(modifier) {
            val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow, boxBlue) = createRefs()

            Box(Modifier.size(175.dp).background(Color.Blue).constrainAs(boxBlue) {
                top.linkTo(boxYellow.bottom)
                end.linkTo(boxYellow.end)
                start.linkTo(boxYellow.start)
            })

            Box(Modifier.size(75.dp).background(Color.Red).constrainAs(boxRed) {
                top.linkTo(boxYellow.bottom)
                start.linkTo(boxYellow.end)
            })
            Box(Modifier.size(75.dp).background(Color.Gray).constrainAs(boxGray) {
                top.linkTo(boxYellow.bottom)
                end.linkTo(boxYellow.start)
            })
            Box(Modifier.size(75.dp).background(Color.Green).constrainAs(boxGreen) {
                start.linkTo(boxYellow.end)
                bottom.linkTo(boxYellow.top)
            })
            Box(Modifier.size(75.dp).background(Color.Magenta).constrainAs(boxMagenta) {
                end.linkTo(boxYellow.start)
                bottom.linkTo(boxYellow.top)
            })

            Box(Modifier.size(75.dp).background(Color.Yellow).constrainAs(boxYellow) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })
        }
    }
}

@Composable
fun MyConstraintLayoutNotSoBasic(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)

        Box(Modifier.size(150.dp).background(Color.Red).constrainAs(boxRed) {
            top.linkTo(topGuide)
        })
    }
}

@Composable
fun ConstraintBarrier(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()
        val barrier = createEndBarrier(boxRed, boxYellow)

        Box(Modifier.size(65.dp).background(Color.Red).constrainAs(boxRed) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })

        Box(Modifier.size(200.dp).background(Color.Yellow).constrainAs(boxYellow) {
            top.linkTo(boxRed.bottom, margin = 40.dp)
            start.linkTo(parent.start, margin = 32.dp)
        })

        Box(Modifier.size(70.dp).background(Color.Cyan).constrainAs(boxCyan) {
            start.linkTo(barrier)
        })
    }
}

@Composable
fun ConstraintChain(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()

        Box(Modifier.size(100.dp).background(Color.Red).constrainAs(boxRed) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(boxYellow.top)
        })

        Box(Modifier.size(100.dp).background(Color.Yellow).constrainAs(boxYellow) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxRed.bottom)
            bottom.linkTo(boxCyan.top)
        })

        Box(Modifier.size(100.dp).background(Color.Cyan).constrainAs(boxCyan) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxYellow.bottom)
            bottom.linkTo(parent.bottom)
        })

        createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.Spread)
    }
}
















