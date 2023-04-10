package com.ahmed.compose.bootcamp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val intent = Intent(this, ConstraintLayout::class.java)
            startActivity(intent)
        }
    }
}