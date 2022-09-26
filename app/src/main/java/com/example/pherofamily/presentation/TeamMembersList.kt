package com.example.pherofamily.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
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
import com.example.pherofamily.controller.TeamMembersController
import com.example.pherofamily.model.Member

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TeamMembersList(
    controller: TeamMembersController,
    navController: NavHostController,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF1b113d))
    ) {
        if (controller.teamMemberState.isLoading) {
            CircularProgressIndicator(color = Color.White)
        } else {
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Heroes of\nProgramming Hero",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(Modifier.height(15.dp))
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)
            ) {
                if (controller.teamMemberState.members != null) {
                    items(controller.teamMemberState.members!!) { member ->
                        MemberCard(
                            member = member,
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MemberCard(
    member: Member,
    navController: NavHostController,
) {
    Card(
        modifier = Modifier.padding(5.dp)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.apply {
                    set("member", member)
                }
                navController.navigate(ScreenItem.MemberDetailsScreenItem.route)
            },
        backgroundColor = Color(0xFF0f0826)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.height(20.dp))
            SubcomposeAsyncImage(
                modifier = Modifier.height(100.dp),
                model = member.profileImage,
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
            Spacer(Modifier.height(20.dp))
            Text(
                text = member.fullName,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(Modifier.height(20.dp))
        }
    }
}