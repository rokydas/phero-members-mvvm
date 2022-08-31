package com.example.pherofamily.data.remote

import com.example.pherofamily.data.remote.responses.TeamMembers
import retrofit2.http.GET

interface PheroApi {

    @GET("team-members")
    suspend fun getMembersList(): TeamMembers

}