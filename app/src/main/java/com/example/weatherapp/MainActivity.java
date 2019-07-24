package com.example.weatherapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.adapter.CityListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.city_list_view)
    ListView cityListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        CityListAdapter adapter = new CityListAdapter(this, Cities.getCities());

        cityListView = findViewById(R.id.city_list_view);

        cityListView.setAdapter(adapter);
    }
}
