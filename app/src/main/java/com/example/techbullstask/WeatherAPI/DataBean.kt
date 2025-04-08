package com.example.techbullstask.WeatherAPI

import java.io.Serializable

data class DataBean(
    val id: Int?,
    val city: String?,
    val country: String?,
    val latitude: Float?,
    val longitude: Float?,
    val temperature: Float?,
    val weather_description: String?,
    val humidity: Int?,
    val wind_speed: Float?,
    val forecast: List<ForecastBean>?
) : Serializable
