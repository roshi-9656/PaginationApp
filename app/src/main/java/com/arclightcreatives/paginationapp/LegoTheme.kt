package com.arclightcreatives.paginationapp

import com.google.gson.annotations.SerializedName

data class LegoTheme(

        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("parent_id")
        val parentId: Int? = null
) :java.io.Serializable