package com.example.weather.domain.usecase

import com.example.weather.domain.entity.Weather
import com.example.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(cityId: Int): Weather = repository.getWeather(cityId)
}