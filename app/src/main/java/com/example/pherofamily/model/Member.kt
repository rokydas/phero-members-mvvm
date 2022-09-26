package com.example.pherofamily.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Member(
    val designation: String,
    val fullName: String,
    val id: String,
    val profileImage: String,
    val team: String
): Parcelable