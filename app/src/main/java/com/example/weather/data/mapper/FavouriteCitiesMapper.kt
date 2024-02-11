package com.example.weather.data.mapper

import com.example.weather.data.local.model.CityDbModel
import com.example.weather.domain.entity.City

fun City.toDbModel(): CityDbModel = CityDbModel(
    id = id,
    name = name,
    country = country
)

fun CityDbModel.toEntity(): City = City(
    id = id,
    name = name,
    country = country
)

fun List<CityDbModel>.toEntities(): List<City> = map { city ->
    city.toEntity()
}