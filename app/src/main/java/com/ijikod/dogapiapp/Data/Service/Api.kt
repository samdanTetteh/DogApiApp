package com.ijikod.dogapiapp.Data.Service

import retrofit2.http.GET

interface Api  {

    @GET("breeds/list/all")
    suspend fun getBreeds()

}