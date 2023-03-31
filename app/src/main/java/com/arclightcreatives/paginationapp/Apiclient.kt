package com.arclightcreatives.paginationapp

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Apiclient {

    private const val BASE_URL: String = "https://rebrickable.com/api/v3/"

    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpLoggingInterceptor : HttpLoggingInterceptor by lazy{
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val okHttpClient :OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

     val apiService :ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}