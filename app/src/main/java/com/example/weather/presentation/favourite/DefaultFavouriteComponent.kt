package com.example.weather.presentation.favourite

import com.arkivanov.decompose.ComponentContext

class DefaultFavouriteComponent(
    private val componentContext: ComponentContext
) : FavouriteComponent, ComponentContext by componentContext {

}