package com.simon.valorantapi

import com.google.gson.annotations.SerializedName
import java.util.Objects

data class ValorantDataResponse (

    @SerializedName("status") val status: Int,
    @SerializedName("data") val valorant: List<ValorantItemResponse>

)

data class ValorantItemResponse (

    @SerializedName("displayName") val name: String,
    @SerializedName("description") val descp: String,
    @SerializedName("fullPortrait") val image: String
)
