package com.example.pherofamily.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pherofamily.data.remote.responses.Member
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {

    var memberDetails by mutableStateOf<Member?>(null)
        private set

    fun addMemberDetails(member: Member) {
        memberDetails = member
    }

}