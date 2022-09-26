package com.example.pherofamily.controller

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.pherofamily.model.TeamMembers
import com.example.pherofamily.presentation.TeamMemberState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TeamMembersController {

    val BASE_URL = "https://hq.programming-hero.com/api/v1/"

    var teamMemberState by mutableStateOf(TeamMemberState())
        private set

    fun getMembersList() {
        val retro = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val api = retro.create(TeamMemberApi::class.java)
        val teamMembersRequest = api.getTeamMembers()

        teamMembersRequest.enqueue(object : Callback<TeamMembers> {
            override fun onResponse(call: Call<TeamMembers>, response: Response<TeamMembers>) {
                val teamMembers = response.body()
                Log.d("ekhane", teamMembers.toString())
                if(teamMembers!!.status) {
                    teamMemberState = teamMemberState.copy(
                        members = teamMembers.data,
                        isLoading = false,
                    )
                } else {
                    teamMemberState = teamMemberState.copy(
                        members = null,
                        isLoading = false,
                        error = "Something went wrong"
                    )
                }
            }

            override fun onFailure(call: Call<TeamMembers>, t: Throwable) {
                Log.d("ekhane", t.message.toString())
                teamMemberState = teamMemberState.copy(
                    members = null,
                    isLoading = false,
                    error = t.message
                )
            }

        })

    }
}
