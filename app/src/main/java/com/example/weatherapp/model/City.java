package com.example.weatherapp.model;

public class City {
    private String name;
    private String country;
    private String artworkUrl;

    public City(String name, String country, String artworkUrl) {
        this.name = name;
        this.country = country;
        this.artworkUrl = artworkUrl;
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
