package com.arclightcreatives.paginationapp

import com.google.gson.annotations.SerializedName

data class LegothemeResponse(
    @SerializedName("results")
    val legoThemesList :ArrayList<LegoTheme>
)
