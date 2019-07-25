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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.temperature);
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
        TextView textViewName = holder.textView;
        textViewName.setText(periods.get(position).getTemperature().toString());
    }

    @Override
    public int getItemCount() {
        return periods.size();
    }
}
