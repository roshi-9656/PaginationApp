package com.arclightcreatives.paginationapp

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import android.content.Context


class Legodatasourcefactory(private val context: Context) : DataSource.Factory<Int, LegoTheme>() {

    val mutableLiveData = MutableLiveData<Legosetsatasource>()

    override fun create(): DataSource<Int, LegoTheme> {
        val userDataSource = Legosetsatasource(context)
        mutableLiveData.postValue(userDataSource)
        return userDataSource
    }
}