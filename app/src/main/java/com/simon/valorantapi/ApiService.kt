package com.simon.valorantapi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/v1/agents/{displayName}")
    suspend fun getCharacters(@Path("displayName") ValName:String): Response<ValorantDataResponse>
}