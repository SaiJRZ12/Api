package com.simon.valorantapi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("https://api.rawg.io/api/games?key=24198b4b31ec4c709630b24afda4a658&dates=2019-09-01,2019-09-30&platforms=18,1,7/{name}")
    suspend fun getCharacters(@Path("name") name:String): Response<ValorantDataResponse>


}