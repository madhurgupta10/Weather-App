package com.example.weatherapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.model.Period;

import java.util.ArrayList;
import java.util.List;

public class WeatherPeriodListAdapter extends RecyclerView.Adapter<WeatherPeriodListAdapter.MyViewHolder> {

    private List<Period> periods = new ArrayList<Period>();

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tempTextView;
        TextView unitTextView;
        TextView dateTextView;
        TextView forecastTextView;

        MyViewHolder(View itemView) {
            super(itemView);
            this.tempTextView = itemView.findViewById(R.id.temp);
            this.unitTextView = itemView.findViewById(R.id.unit);
            this.dateTextView = itemView.findViewById(R.id.date);
            this.forecastTextView = itemView.findViewById(R.id.forecast);
        }
    }

    public WeatherPeriodListAdapter(List<Period> periods) {
        this.periods = periods;
    }

    @NonNull
    @Override
    public WeatherPeriodListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_card_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherPeriodListAdapter.MyViewHolder holder, int position) {

        TextView nameTextView = holder.tempTextView;
        TextView unitTextView = holder.unitTextView;
        TextView dateTextView = holder.dateTextView;
        TextView forecastTextView = holder.forecastTextView;

        // Setting the values for each view.
        nameTextView.setText(periods.get(position).getTemperature().toString());
        unitTextView.setText(periods.get(position).getTemperatureUnit());
        dateTextView.setText(periods.get(position).getName());
        forecastTextView.setText(periods.get(position).getDetailedForecast());
    }

    @Override
    public int getItemCount() {
        return periods.size();
    }
}
