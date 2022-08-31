package com.example.pherofamily.repository
import com.example.pherofamily.data.remote.responses.TeamMembers
import com.example.pherofamily.util.Resource

interface PheroRepository {
    suspend fun getTeamMembers(): Resource<TeamMembers>
}