package com.example.pherofamily.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
fun TeamMemberDetailsScreen(
    sharedViewModel: SharedViewModel
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b113d))
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier.height(200.dp),
            model = sharedViewModel.memberDetails?.profileImage,
            contentDescription = "course thumbnail",
            contentScale = ContentScale.FillHeight
        ) {
            when (painter.state) {
                is AsyncImagePainter.State.Loading -> {
                    CircularProgressIndicator(color = Color.White)
                }
                else -> {
                    SubcomposeAsyncImageContent()
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = sharedViewModel.memberDetails!!.fullName,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = sharedViewModel.memberDetails!!.designation,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Team: " + sharedViewModel.memberDetails!!.team,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}