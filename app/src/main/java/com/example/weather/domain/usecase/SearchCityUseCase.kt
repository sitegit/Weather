package com.example.weather.domain.usecase

import com.example.weather.domain.entity.City
import com.example.weather.domain.repository.SearchRepository
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    private val repository: SearchRepository
) {

    suspend operator fun invoke(query: String): List<City> = repository.search(query)
}