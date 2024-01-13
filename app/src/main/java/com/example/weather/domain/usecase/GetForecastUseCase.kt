package com.example.weather.domain.usecase

import com.example.weather.domain.entity.Forecast
import com.example.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(cityId: Int): Forecast = repository.getForecast(cityId)
}