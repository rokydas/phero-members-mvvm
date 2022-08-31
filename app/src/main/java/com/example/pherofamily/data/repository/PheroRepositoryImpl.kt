package com.example.pherofamily.data.repository

import com.example.pherofamily.data.remote.PheroApi
import com.example.pherofamily.data.remote.responses.TeamMembers
import com.example.pherofamily.repository.PheroRepository
import com.example.pherofamily.util.Resource
import javax.inject.Inject

class PheroRepositoryImpl @Inject constructor(
    private val api: PheroApi
): PheroRepository {

    override suspend fun getTeamMembers(): Resource<TeamMembers> {
        val response = try {
            api.getMembersList()
        } catch(e: Exception){
            return Resource.Error("Something went wrong...")
        }
        return Resource.Success(response)
    }
}