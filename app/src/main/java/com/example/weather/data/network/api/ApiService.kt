package com.example.weather.data.network.api

import com.example.weather.data.network.model.CityDto
import com.example.weather.data.network.model.WeatherCurrentDto
import com.example.weather.data.network.model.WeatherForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("current.json")
    suspend fun loadCurrentWeather(
        @Query("q") query: String
    ): WeatherCurrentDto

    @GET("forecast.json")
    suspend fun loadForecast(
        @Query("q") query: String,
        @Query("days") daysCount: Int = 4
    ): WeatherForecastDto

    @GET("search.json")
    suspend fun searchCity(
        @Query("q") query: String
    ): List<CityDto>
}