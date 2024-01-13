package com.example.weather.data.network.model

import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday") val forecastDays: List<DayDto>
)
