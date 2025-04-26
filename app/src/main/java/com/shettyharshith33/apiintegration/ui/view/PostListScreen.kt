package com.shettyharshith33.apiintegration.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shettyharshith33.apiintegration.ui.theme.Purple80
import com.shettyharshith33.apiintegration.ui.theme.myGreen
import com.shettyharshith33.model.Post
import com.shettyharshith33.viewModel.PostViewModel
import com.valentinilk.shimmer.shimmer

@Composable
fun PostListScreen(viewModel: PostViewModel = PostViewModel()) {
    val posts by viewModel.posts

    if (posts.isEmpty()) {
//        Column(modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center) {
//            CircularProgressIndicator(color = myGreen)
//        }
        ShimmerLoadingScreen()
    } else {
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            items(posts) {
                PostCard(it)
            }
        }
    }
}

@Composable
fun PostCard(post: Post) {
    Spacer(modifier = Modifier.height(25.dp))
    Card(
        modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors().copy(
            containerColor = Purple80
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Post: ${post.id}", style = MaterialTheme.typography.bodyLarge, color = Color.Black
            )
            Text(
                post.title, style = MaterialTheme.typography.bodyMedium, color = Color.Black
            )
            Text(
                post.body, style = MaterialTheme.typography.bodySmall, color = Color.Black
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun ShimmerLoadingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .shimmer() // Applying shimmer effect
    ) {
        repeat(5) { // 5 dummy skeleton posts
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(vertical = 8.dp),
                color = Color.LightGray, // Light Grey skeleton
                shape = RoundedCornerShape(16.dp)
            ) {}
        }
    }
}