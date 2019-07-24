package com.example.weatherapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.R;
import com.example.weatherapp.WeatherActivity;
import com.example.weatherapp.model.City;
import com.squareup.picasso.Picasso;

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

        // Getting the city object at the specific position in the array list.
        final City city = (City) getItem(position);

        // Finding the views and setting their values.
        TextView cityNameTextView = view.findViewById(R.id.city_name);
        TextView countryNameTextView = view.findViewById(R.id.country_name);
        ImageView artworkImageView = view.findViewById(R.id.artwork_image);

        cityNameTextView.setText(city.getName());
        countryNameTextView.setText(city.getCountry());

        Picasso.with(mContext).load(city.getArtworkUrl()).into(artworkImageView);

        // Implements the on click listener and directs it to the Weather Activity.
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WeatherActivity.class);
                intent.putExtra("CityObject", city);
                mContext.startActivity(intent);
            }

        });

        return view;
    }
}