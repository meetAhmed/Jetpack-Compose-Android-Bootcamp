package com.ahmed.compose.bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class Modifiers : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .padding(10.dp)
                    .padding(start = 20.dp)
                    .border(0.5.dp, Color.Black)
                    .padding(20.dp)
//                    .width(600.dp)
//                    .requiredWidth(600.dp)
            ) {
                Text("Hello", modifier = Modifier.offset())
                Spacer(modifier = Modifier.height(20.dp))
                Text("World")
                Spacer(modifier = Modifier.height(10.dp))
                Text("Click me", modifier = Modifier.clickable { })
            }
        }
    }
}