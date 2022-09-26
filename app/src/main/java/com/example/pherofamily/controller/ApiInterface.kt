package com.example.pherofamily.controller

import com.example.pherofamily.model.TeamMembers
import retrofit2.Call
import retrofit2.http.GET

interface TeamMemberApi {
    @GET("team-members")
    fun getTeamMembers(): Call<TeamMembers>
}