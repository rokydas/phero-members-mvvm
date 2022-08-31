package com.example.pherofamily.presentation
import com.example.pherofamily.data.remote.responses.Member

data class TeamMemberState(
    val members: List<Member>? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)
