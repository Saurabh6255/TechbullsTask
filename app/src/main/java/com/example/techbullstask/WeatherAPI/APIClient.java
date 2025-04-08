package com.example.techbullstask.WeatherAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClient {

    @GET("weathers")
    Call<List<DataBean>> getWeatherData();

}
