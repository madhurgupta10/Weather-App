package com.example.weatherapp.model;

public class City {
    private String name;
    private String country;
    private String artworkUrl;
    private double longi;
    private double lati;

    public City(String name, String country, String artworkUrl, double longi, double lati) {
        this.name = name;
        this.country = country;
        this.artworkUrl = artworkUrl;
        this.longi = longi;
        this.lati = lati;
    }

    public double getLongi() {
        return longi;
    }

    public double getLati() {
        return lati;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

}
