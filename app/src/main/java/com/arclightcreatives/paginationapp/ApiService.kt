package com.arclightcreatives.paginationapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("lego/themes/?key=15e30802a0f5d4691987f0842ca2eff2")
     fun getThemes(@Query("page") page: Int? = null,
                          @Query("page_size") pageSize: Int? = null,
                          @Query("ordering") order: String? = null): Call<LegothemeResponse>

}