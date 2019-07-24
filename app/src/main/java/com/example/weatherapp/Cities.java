package com.example.weatherapp;

import com.example.weatherapp.model.City;

import java.util.ArrayList;

public class Cities {

    private static ArrayList<City> cities = new ArrayList<City>();

    // getCities method add cities to an ArrayList and returns it.
    public static ArrayList<City> getCities() {

        cities.add(addCity(
                "Chicago",
                "USA",
                "541263/screenshots/3606770/1efe2553451829.59356c47493af_-_kopia.jpg")
        );

        cities.add(addCity(
                "New York",
                "USA",
                "2546897/screenshots/5816083/liberty-01-01-01_4x.jpg")
        );

        cities.add(addCity(
                "Miami",
                "USA",
                "225954/screenshots/2079577/miami_beach_shot.png")
        );

        cities.add(addCity(
                "San Francisco",
                "USA",
                "1499888/screenshots/3348525/ggb-puzzle.png")
        );

        return cities;
    }


    /* addCity method creates and returns a new City object.
    *  It accepts three parameters city name, country name and artwork url.
    *  The artwork url is concatenated with the base url of dribble cdn before returning the object.
    * */
    public static City addCity(String cityName, String countryName, String artworkUrl) {

        String dribbleBaseUrl = "https://cdn.dribbble.com/users/";

        return new City(cityName, countryName, dribbleBaseUrl + artworkUrl);
    }
}
