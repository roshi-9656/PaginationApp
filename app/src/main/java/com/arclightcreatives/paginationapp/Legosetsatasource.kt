package com.arclightcreatives.paginationapp

import android.content.Context
import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Legosetsatasource(private val context: Context) : PageKeyedDataSource<Int, LegoTheme>() {

    private val pagesize: Int = 50
    private val firstpage: Int = 1

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, LegoTheme>
    ) {
        getLegothemes(callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, LegoTheme>) {
        val previousPageNo = if (params.key > 1) params.key - 1 else 0
        getMoreLegothemes(params.key, previousPageNo, callback)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, LegoTheme>) {
        val nextPageNo = params.key + 1
        getMoreLegothemes(params.key, nextPageNo, callback)
    }


    fun getLegothemes(callback: LoadInitialCallback<Int, LegoTheme>) {

        Apiclient.apiService.getThemes(firstpage, 50, "id")
            .enqueue(object : Callback<LegothemeResponse> {
                override fun onResponse(
                    call: Call<LegothemeResponse>,
                    response: Response<LegothemeResponse>
                ) {
                    val legothemeResponse = response.body()
                    val listLegothemes = legothemeResponse?.legoThemesList
                    listLegothemes?.let {
                        callback.onResult(it, null, 2)
                    }

                }

                override fun onFailure(call: Call<LegothemeResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }


            })
    }


    private fun getMoreLegothemes(
        pageNo: Int,
        previousOrNextPageNo: Int,
        callback: LoadCallback<Int, LegoTheme>
    ) {

        Apiclient.apiService.getThemes(previousOrNextPageNo, pagesize, "id")
            .enqueue(object : Callback<LegothemeResponse> {
                override fun onFailure(call: Call<LegothemeResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<LegothemeResponse>,
                    response: Response<LegothemeResponse>
                ) {
                    val userResponse = response.body()
                    val listUsers = userResponse?.legoThemesList
                    listUsers?.let { callback.onResult(it, previousOrNextPageNo) }
                }

            })

    }
}