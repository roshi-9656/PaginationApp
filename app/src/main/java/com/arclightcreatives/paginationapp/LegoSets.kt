package com.arclightcreatives.paginationapp

import com.google.gson.annotations.SerializedName

data class LegoSets (
        @field:SerializedName("set_num")
        val id: String,
        @field:SerializedName("name")
        val name: String,
        @field:SerializedName("set_img_url")
        val imageUrl: String? = null,
        @field:SerializedName("theme_id")
        val themeId: Int,
        @field:SerializedName("last_modified_dt")
        val lastModifiedDate: String? = null,
        @field:SerializedName("num_parts")
        val numParts: Int? = null,
        @field:SerializedName("set_url")
        val url: String? = null,
        @field:SerializedName("year")
        val year: Int? = null
        ) :java.io.Serializable