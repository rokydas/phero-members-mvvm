package com.example.pherofamily.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pherofamily.controller.TeamMembersController
import com.example.pherofamily.model.Member
import com.example.pherofamily.ui.theme.PheroFamilyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamMembersActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val controller = TeamMembersController()

        lifecycleScope.launch {
            controller.getMembersList()
        }

        setContent {
            PheroFamilyTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenItem.MemberListScreen.route
                    ) {
                        composable(route = ScreenItem.MemberListScreen.route) {
                            TeamMembersList(
                                controller = controller,
                                navController = navController,
                            )
                        }
                        composable(route = ScreenItem.MemberDetailsScreenItem.route) {
                            val member = navController.previousBackStackEntry?.savedStateHandle?.get<Member>("member")
                            if (member != null) {
                                TeamMemberDetailsScreen(member = member)
                            }
                        }
                    }
                }
            }
        }
    }
}