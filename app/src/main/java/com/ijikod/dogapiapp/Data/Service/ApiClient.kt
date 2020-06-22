package com.ijikod.dogapiapp.Data.Service

import com.ijikod.dogapiapp.SERVER_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private val retrofit: Retrofit


    init {
        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS) // You can remove timeouts.
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder().baseUrl(SERVER_URL).addConverterFactory(MoshiConverterFactory.create()) .client(okHttpClient).build()
    }


    fun getService(): Api = retrofit.create(Api::class.java)
}