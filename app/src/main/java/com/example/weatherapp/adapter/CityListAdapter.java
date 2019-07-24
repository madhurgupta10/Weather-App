package com.example.weatherapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.R;
import com.example.weatherapp.client.RetrofitApiClientInstance;
import com.example.weatherapp.model.City;
import com.example.weatherapp.model.WeatherInfo;
import com.example.weatherapp.service.GetDataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        ImageView artworkImageView = view.findViewById(R.id.artwork_image);

        cityNameTextView.setText(city.getName());
        countryNameTextView.setText(city.getCountry());

        Picasso.with(mContext).load(city.getArtworkUrl()).into(artworkImageView);

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GetDataService service = RetrofitApiClientInstance
                        .getRetrofitInstance().create(GetDataService.class);
                Call<WeatherInfo> call = service.getWeatherInfo(city.getLongi()+","+city.getLati());
                call.enqueue(new Callback<WeatherInfo>() {
                    @Override
                    public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                        Toast.makeText(mContext, ""+response.body().getProperties().getPeriods().get(0).getTemperature(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<WeatherInfo> call, Throwable t) {
                        Log.d("RETRO", "onFailure: "+t);
                    }
                });
            }

        });

        return view;
    }
}