package com.example.weather.domain.usecase

import com.example.weather.domain.entity.City
import com.example.weather.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteCitiesUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {

    operator fun invoke(): Flow<City> = repository.favouriteCities
}