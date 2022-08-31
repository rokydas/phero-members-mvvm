package com.example.pherofamily.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pherofamily.presentation.TeamMemberState
import com.example.pherofamily.repository.PheroRepository
import com.example.pherofamily.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TeamMembersViewModel @Inject constructor(
    private val repository: PheroRepository
) : ViewModel() {

    var teamMemberState by mutableStateOf(TeamMemberState())
        private set

    suspend fun getMembersList() {
        when(val result = repository.getTeamMembers()) {
            is Resource.Success -> {
                teamMemberState = teamMemberState.copy(
                    members = result.data?.data,
                    isLoading = false,
                    error = null
                )
            }
            is Resource.Error -> {
                teamMemberState = teamMemberState.copy(
                    members = null,
                    isLoading = false,
                    error = result.message
                )
            }
            else -> {

            }
        }
    }
}
