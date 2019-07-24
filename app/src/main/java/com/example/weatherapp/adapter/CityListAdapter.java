package com.example.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.model.City;

import java.util.ArrayList;

public class CityListAdapter extends BaseAdapter {

    private ArrayList<City> cities = new ArrayList<City>();
    private Context mContext;

    public CityListAdapter(Context context, ArrayList<City> cities) {
        this.mContext = context;
        this.cities = cities;
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // This method inflates the city card layout for the list of cities provided.
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.city_card_layout, parent, false);
        }

        final City city = (City) getItem(position);

        TextView cityNameTextView = view.findViewById(R.id.city_name);
        TextView countryNameTextView = view.findViewById(R.id.country_name);

        cityNameTextView.setText(city.getName());
        countryNameTextView.setText(city.getCountry());

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }

        });

        return view;
    }
}