package com.example.weather.data.network.model

import com.google.gson.annotations.SerializedName

data class WeatherCurrentDto(
    @SerializedName("current") val current: WeatherDto
)