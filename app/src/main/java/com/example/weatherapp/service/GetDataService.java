package com.example.weatherapp.service;

import com.example.weatherapp.model.WeatherInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("points/{coords}/forecast")
    Call<WeatherInfo> getWeatherInfo(@Path(value = "coords", encoded = true) String coords);
}
