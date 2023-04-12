package com.ahmed.compose.bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.util.*
import kotlin.random.Random

class InstagramFeedUIBootcamp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedScreen()
        }
    }
}

@Composable
fun FeedScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(80.dp)
        ) {
            RoundedImageCard(image = R.drawable.guy)
            VerticalDivider()
            LazyRow {
                items(mockStories.size) {
                    RoundedImageCard(image = mockStories[it].image)
                }
            }
        }
        HorizontalDivider()
        LazyColumn {
            items(mockPosts.size) {
                PostItem(item = mockPosts[it])
            }
        }
    }
}

@Composable
fun RoundedImageCard(
    image: Int,
    modifier: Modifier = Modifier
        .padding(8.dp)
        .size(64.dp)
) {
    Card(
        shape = CircleShape,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun VerticalDivider() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .fillMaxHeight()
            .alpha(0.3f)
            .padding(top = 8.dp, bottom = 8.dp)
            .background(Color.LightGray)
    )
}

@Composable
fun HorizontalDivider() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier
                .alpha(0.3f)
                .padding(top = 8.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun PostItem(item: MockPost) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundedImageCard(
                image = item.userImage,
                modifier = Modifier
                    .size(48.dp)
                    .padding(4.dp)
            )
            Text(text = item.userName, fontWeight = FontWeight.Bold)
        }
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(text = item.description, modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.Red)
            )
            Text(text = "${item.likes} likes", modifier = Modifier.padding(8.dp))
        }
        Text(
            text = "${item.comments} comments",
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp),
            color = Color.Gray
        )
    }
}

val animalsList = listOf(
    R.drawable.ape, R.drawable.bear, R.drawable.bird, R.drawable.bison, R.drawable.cat,
    R.drawable.chicken, R.drawable.cow, R.drawable.deer, R.drawable.dog, R.drawable.dolphin,
    R.drawable.duck, R.drawable.eagle, R.drawable.fish, R.drawable.horse, R.drawable.lion,
    R.drawable.lobster, R.drawable.monkey, R.drawable.pig, R.drawable.pony, R.drawable.rabbit,
    R.drawable.shark, R.drawable.snake, R.drawable.spider, R.drawable.turkey, R.drawable.wolf
)

val commonNames = listOf(
    "Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Elijah",
    "Charlotte", "William", "Sophia", "James", "Amelia", "Benjamin", "Isabella", "Lucas",
    "Mia", "Henry", "Evelyn", "Alexander", "Harper"
)

val mockStories = List(20) {
    val uid = UUID.randomUUID().toString()
    val image = animalsList[Random.nextInt(animalsList.size)]
    MockStory(uid, image)
}

val mockPosts = List(100) {
    val uid = UUID.randomUUID().toString()
    val userImage = R.drawable.guy
    val username = commonNames[Random.nextInt(commonNames.size)]
    val image = animalsList[Random.nextInt(animalsList.size)]
    val description = "This is a random description ${Random.nextFloat()}"
    val likes = Random.nextInt(1000)
    val comments = Random.nextInt(100)
    MockPost(uid, userImage, username, image, description, likes, comments)
}

data class MockStory(
    val storyId: String,
    val image: Int
)

data class MockPost(
    val postId: String,
    val userImage: Int,
    val userName: String,
    val image: Int,
    val description: String,
    val likes: Int,
    val comments: Int
)