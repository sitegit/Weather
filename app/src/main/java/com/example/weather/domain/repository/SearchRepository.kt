package com.example.weather.domain.repository

import com.example.weather.domain.entity.City

interface SearchRepository {

    fun search(query: String): List<City>
}