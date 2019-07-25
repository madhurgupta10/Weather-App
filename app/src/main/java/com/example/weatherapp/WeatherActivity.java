package com.example.weatherapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.adapter.WeatherPeriodListAdapter;
import com.example.weatherapp.client.RetrofitApiClientInstance;
import com.example.weatherapp.model.City;
import com.example.weatherapp.model.Period;
import com.example.weatherapp.model.WeatherInfo;
import com.example.weatherapp.service.GetDataService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private City city;

    private TextView temperatureTextView;
    private TextView unitTextView;
    private TextView cityNameTextView;
    private TextView infoTextView;
    private TextView dateTextView;
    private RelativeLayout container;
    private RecyclerView weatherCardRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        temperatureTextView = findViewById(R.id.temp);
        unitTextView = findViewById(R.id.unit);
        cityNameTextView = findViewById(R.id.name);
        infoTextView = findViewById(R.id.info);
        dateTextView = findViewById(R.id.date);

        container = findViewById(R.id.container);
        weatherCardRecyclerView = findViewById(R.id.weather_recycler);

        startGradientAnimation(container);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Gets the city object from the intent.
        City city = (City) getIntent().getSerializableExtra("CityObject");

        if (city != null) {
            this.city = city;
            callApi(city.getLongi(), city.getLati());
        }

    }

    private void startGradientAnimation(RelativeLayout container) {
        AnimationDrawable animationDrawable = (AnimationDrawable) container.getBackground();
        animationDrawable.setEnterFadeDuration(100);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    // This method will invoke the API and fetch the response.
    private void callApi(double longi, double lati) {
        String coordinate = longi + "," + lati;

        GetDataService service = RetrofitApiClientInstance
                .getRetrofitInstance().create(GetDataService.class);
        Call<WeatherInfo> call = service.getWeatherInfo(coordinate);
        call.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                setViews(response.body());
            }

            private void setViews(WeatherInfo body) {
                temperatureTextView.setText(body.getProperties().getPeriods().get(0)
                        .getTemperature().toString());
                infoTextView.setText(body.getProperties().getPeriods().get(0).getShortForecast());
                cityNameTextView.setText(city.getName());
                unitTextView.setText(R.string.unit_F);
                dateTextView.setText(getCurrentDate());
                setRecyclerView(weatherCardRecyclerView, body.getProperties().getPeriods());
            }

            private void setRecyclerView(RecyclerView weatherCardRecyclerView,
                                         List<Period> periods) {
                WeatherPeriodListAdapter weatherPeriodListAdapter = new WeatherPeriodListAdapter(periods);
                LinearLayoutManager horizontalLayoutManagaer
                        = new LinearLayoutManager(WeatherActivity.this,
                        LinearLayoutManager.HORIZONTAL, false);
                weatherCardRecyclerView.setLayoutManager(horizontalLayoutManagaer);
                weatherCardRecyclerView.setAdapter(weatherPeriodListAdapter);
            }

            // Returns the current date of the device in date month year format.
            private String getCurrentDate() {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                return df.format(calendar.getTime());
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable throwable) {
                Toast.makeText(WeatherActivity.this,
                        R.string.went_wrong, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (city != null) {
            // Add a marker and move the camera
            LatLng latLng = new LatLng(city.getLongi(), city.getLati());
            mMap.addMarker(new MarkerOptions().position(latLng).title(city.getName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10F));
        }
    }
}
