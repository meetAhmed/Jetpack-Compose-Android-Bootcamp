package com.ahmed.compose.bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId

class ConstraintLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")

                constrain(greenBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(redBox) {
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
            }

            androidx.constraintlayout.compose.ConstraintLayout(
                constraints,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .background(color = androidx.compose.ui.graphics.Color.Green)
                        .layoutId("greenBox")
                )

                Box(
                    modifier = Modifier
                        .background(color = androidx.compose.ui.graphics.Color.Red)
                        .layoutId("redBox")
                )
            }
        }
    }
}