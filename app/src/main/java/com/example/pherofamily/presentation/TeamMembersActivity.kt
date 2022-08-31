package com.example.pherofamily.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pherofamily.ui.theme.PheroFamilyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamMembersActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: TeamMembersViewModel by viewModels()
        val sharedViewModel: SharedViewModel by viewModels()

        lifecycleScope.launch {
            viewModel.getMembersList()
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
                                viewModel = viewModel,
                                sharedViewModel = sharedViewModel,
                                navController = navController
                            )
                        }
                        composable(route = ScreenItem.MemberDetailsScreenItem.route) {
                            TeamMemberDetailsScreen(
                                sharedViewModel = sharedViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}