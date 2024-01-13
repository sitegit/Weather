package com.example.weather.data.network.model

import com.google.gson.annotations.SerializedName

data class DayWeatherDto(
    @SerializedName("avgtemp_c") val tempC: Float,
    @SerializedName("condition") val condition: ConditionDto
)
