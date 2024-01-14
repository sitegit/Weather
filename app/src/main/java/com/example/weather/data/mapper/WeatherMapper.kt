package com.example.weather.data.mapper

import com.example.weather.data.network.dto.WeatherCurrentDto
import com.example.weather.data.network.dto.WeatherDto
import com.example.weather.data.network.dto.WeatherForecastDto
import com.example.weather.domain.entity.Forecast
import com.example.weather.domain.entity.Weather
import java.util.Calendar
import java.util.Date

fun WeatherCurrentDto.toEntity(): Weather = current.toEntity()

fun WeatherDto.toEntity(): Weather = Weather(
    tempC = tempC,
    conditionText = condition.text,
    conditionUrl = condition.iconUrl.createIconUrl(),
    date = date.toCalendar()
)

fun WeatherForecastDto.toEntity(): Forecast = Forecast(
    currentWeather = current.toEntity(),
    upcoming = forecastDto.forecastDays.drop(1).map { dayDto ->
        val dayWeatherDto = dayDto.dayWeatherDto

        Weather(
            tempC = dayWeatherDto.tempC,
            conditionText = dayWeatherDto.conditionDto.text,
            conditionUrl = dayWeatherDto.conditionDto.iconUrl.createIconUrl(),
            date = dayDto.date.toCalendar()
        )
    }
)

private fun Long.toCalendar(): Calendar = Calendar.getInstance().apply {
    time = Date(this@toCalendar * 1000)
}

private fun String.createIconUrl(): String = "https:$this".replace(
    oldValue = "64x64",
    newValue = "128x128"
)