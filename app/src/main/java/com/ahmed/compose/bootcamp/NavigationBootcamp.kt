package com.ahmed.compose.bootcamp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class NavigationBootcamp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationAppHost(navController = navController)
        }
    }
}

sealed class Destination(val route: String) {
    object Listing : Destination("listing")
    object Details : Destination("details/{elementId}") {
        fun createRoute(elementId: Int) = "details/$elementId"
    }
}

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destination.Listing.route) {
        composable(Destination.Listing.route) { ListScreen(navController = navController) }
        composable(Destination.Details.route) { navBackStackEntry ->
            val elementId = navBackStackEntry.arguments?.getString("elementId")
            if (elementId == null) {
                Toast.makeText(
                    LocalContext.current,
                    "Element id must not be null",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                DetailScreen(elementId = elementId)
            }
        }
    }
}

@Composable
fun DetailScreen(elementId: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Detail Screen")
        Text(text = "Item clicked: $elementId")
    }
}

@Composable
fun ListScreen(
    navController: NavHostController
) {
    val elements = MutableList(100) { it }
    LazyColumn(modifier = Modifier.background(Color.LightGray)) {
        items(elements.size) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .padding(4.dp)
                    .clickable {
                        navController.navigate(Destination.Details.createRoute(it))
                    }
            ) {
                Text(text = "Element $it")
            }
        }
    }
}




