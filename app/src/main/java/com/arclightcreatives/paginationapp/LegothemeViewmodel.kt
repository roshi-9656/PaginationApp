package com.arclightcreatives.paginationapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class LegothemeViewmodel(private val context: Context) : ViewModel() {

    private var listLegothemes: LiveData<PagedList<LegoTheme>> =
        MutableLiveData<PagedList<LegoTheme>>()
    private var mutableLiveData = MutableLiveData<Legosetsatasource>()


    init {
        val factory : Legodatasourcefactory by lazy {
            Legodatasourcefactory(context)
        }
        mutableLiveData = factory.mutableLiveData

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(6)
            .build()

        listLegothemes = LivePagedListBuilder(factory, config).build()
    }


    fun getData() : LiveData<PagedList<LegoTheme>>{
        return listLegothemes
    }

}