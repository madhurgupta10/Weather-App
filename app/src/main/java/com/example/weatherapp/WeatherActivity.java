package com.example.weatherapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.client.RetrofitApiClientInstance;
import com.example.weatherapp.model.City;
import com.example.weatherapp.model.WeatherInfo;
import com.example.weatherapp.service.GetDataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        City city = (City) getIntent().getSerializableExtra("CityObject");
        callApi(city.getLongi(), city.getLati());

    }

    private void callApi(double longi, double lati) {
        String coordinate = longi + "," + lati;

        GetDataService service = RetrofitApiClientInstance
                .getRetrofitInstance().create(GetDataService.class);
        Call<WeatherInfo> call = service.getWeatherInfo(coordinate);
        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                Toast.makeText(WeatherActivity.this, ""+response.body().getProperties().getPeriods().get(0).getTemperature(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
            }
        });
    }
}
