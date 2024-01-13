package com.example.weather.data.network.model

import com.google.gson.annotations.SerializedName

data class DayDto(
    @SerializedName("date_epoch") val date: Long,
    @SerializedName("day") val day: DayWeatherDto
)
