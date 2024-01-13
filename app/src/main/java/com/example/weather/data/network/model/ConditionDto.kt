package com.example.weather.data.network.model

import com.google.gson.annotations.SerializedName

data class ConditionDto(
    @SerializedName("text") val text: String,
    @SerializedName("icon") val iconUrl: String
)