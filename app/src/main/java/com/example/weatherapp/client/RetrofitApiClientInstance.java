package com.example.weatherapp.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClientInstance {

    /**
     * Retrofit Client Instance class is implemented which will build the http request.
     * This also reads the JSON stream of data and parse it to Java Objects using GSON library.
     */

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.weather.gov/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
