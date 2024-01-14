package com.example.weather.di

import android.content.Context
import com.example.weather.data.local.db.AppDatabase
import com.example.weather.data.local.db.FavouriteCitiesDao
import com.example.weather.data.network.api.ApiFactory
import com.example.weather.data.network.api.ApiService
import com.example.weather.data.repository.FavouriteRepositoryImpl
import com.example.weather.data.repository.SearchRepositoryImpl
import com.example.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.domain.repository.FavouriteRepository
import com.example.weather.domain.repository.SearchRepository
import com.example.weather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @ApplicationScope
    @Binds
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

    @ApplicationScope
    @Binds
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideApiService() : ApiService = ApiFactory.apiService

        @ApplicationScope
        @Provides
        fun provideDatabase(context: Context): AppDatabase = AppDatabase.getInstance(context)

        @ApplicationScope
        @Provides
        fun provideFavouriteCitiesDao(database: AppDatabase): FavouriteCitiesDao =
            database.favouriteCitiesDao()
    }
}