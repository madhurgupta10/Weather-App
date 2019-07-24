package com.example.weatherapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.adapter.CityListAdapter;
import com.example.weatherapp.model.City;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Bind views using butter knife.
    @BindView(R.id.city_list_view)
    ListView cityListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Fetching the required cities to display the relevant information
        ArrayList<City> cities = Cities.getCities();

        // Check if list is non empty
        if (cities.size() > 0) {

            CityListAdapter adapter = new CityListAdapter(this, cities);

            cityListView = findViewById(R.id.city_list_view);

            cityListView.setAdapter(adapter);

        } else {
            Toast.makeText(this, R.string.no_info, Toast.LENGTH_SHORT).show();
        }
    }
}
