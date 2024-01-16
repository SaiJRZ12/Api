package com.simon.api

import com.google.gson.annotations.SerializedName

data class RAWGDataResponse (

    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<RAWGItemResponse>

    )

data class RAWGItemResponse (

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("released") val released: String,
    @SerializedName("rating") val rating: Float,
    @SerializedName("background_image") val img: String
)
