package com.simon.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {


   /* @GET("/games")
    suspend fun search(@Query("name") name: String): Response<RAWGDataResponse>*/

    @GET("games?key=24198b4b31ec4c709630b24afda4a658")
    suspend fun getGames(@Query("search") search: String): Response<RAWGDataResponse>



}