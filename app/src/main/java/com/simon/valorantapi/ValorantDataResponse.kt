package com.simon.valorantapi

import com.google.gson.annotations.SerializedName
import java.util.Objects

data class ValorantDataResponse (

    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<ValorantItemResponse>,

    )

data class ValorantItemResponse (

    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("released") val released: String,
    @SerializedName("rating") val rating: Int
)
