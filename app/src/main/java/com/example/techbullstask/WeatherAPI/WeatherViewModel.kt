package com.example.techbullstask.WeatherAPI

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel(private val repo: WeatherRepo) : ViewModel() {
    fun getWeatherList(): LiveData<List<DataBean>> {
        return repo.getWeatherList()
    }
}