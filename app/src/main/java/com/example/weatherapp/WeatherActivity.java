package com.example.weatherapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.weatherapp.client.RetrofitApiClientInstance;
import com.example.weatherapp.model.City;
import com.example.weatherapp.model.WeatherInfo;
import com.example.weatherapp.service.GetDataService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private City city;
    
//    @BindView(R.id.temp)
    TextView temperatureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
//        ButterKnife.bind(this);

        temperatureTextView = findViewById(R.id.temp);

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
                //cityNameTextView.setText(city.getName());
                temperatureTextView.setText(body.getProperties().getPeriods().get(0).getTemperature().toString());
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
            mMap.addMarker(new MarkerOptions().position(latLng)
                    .title(String.format("Marker in %s", city.getName())));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10F));
        }
    }
}
