package com.example.techbullstask.WeatherAPI

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepo(private val context: Context) {

    private val apiClient = RetrofitInstance.getInstance().create(APIClient::class.java)

    fun getWeatherList(): LiveData<List<DataBean>> {
        val data = MutableLiveData<List<DataBean>>()

        apiClient.getWeatherData().enqueue(object : Callback<List<DataBean>> {
            override fun onResponse(call: Call<List<DataBean>>, response: Response<List<DataBean>>) {
                if (response.isSuccessful && response.body() != null) {
                    data.value = response.body()
                } else {
                    Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<DataBean>>, t: Throwable) {
                Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        return data
    }
}


