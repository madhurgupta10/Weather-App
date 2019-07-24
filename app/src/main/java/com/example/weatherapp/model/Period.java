package com.example.weatherapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Period {

    @SerializedName("number")
    @Expose
    private Integer number;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("startTime")
    @Expose
    private String startTime;

    @SerializedName("endTime")
    @Expose
    private String endTime;

    @SerializedName("isDaytime")
    @Expose
    private Boolean isDaytime;

    @SerializedName("temperature")
    @Expose
    private Integer temperature;

    @SerializedName("temperatureUnit")
    @Expose
    private String temperatureUnit;

    @SerializedName("temperatureTrend")
    @Expose
    private Object temperatureTrend;

    @SerializedName("windSpeed")
    @Expose
    private String windSpeed;

    @SerializedName("windDirection")
    @Expose
    private String windDirection;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("shortForecast")
    @Expose
    private String shortForecast;

    @SerializedName("detailedForecast")
    @Expose
    private String detailedForecast;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsDaytime() {
        return isDaytime;
    }

    public void setIsDaytime(Boolean isDaytime) {
        this.isDaytime = isDaytime;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public Object getTemperatureTrend() {
        return temperatureTrend;
    }

    public void setTemperatureTrend(Object temperatureTrend) {
        this.temperatureTrend = temperatureTrend;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getShortForecast() {
        return shortForecast;
    }

    public void setShortForecast(String shortForecast) {
        this.shortForecast = shortForecast;
    }

    public String getDetailedForecast() {
        return detailedForecast;
    }

    public void setDetailedForecast(String detailedForecast) {
        this.detailedForecast = detailedForecast;
    }

}
