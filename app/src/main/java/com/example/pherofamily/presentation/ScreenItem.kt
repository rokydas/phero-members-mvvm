package com.example.pherofamily.presentation

sealed class ScreenItem(val route: String) {
    object MemberListScreen : ScreenItem("member_list_screen")
    object MemberDetailsScreenItem : ScreenItem("member-details_screen")
}
