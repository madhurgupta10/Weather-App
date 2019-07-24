package com.example.weatherapp.model;

import java.util.ArrayList;

public class Cities {

    private static ArrayList<City> cities = new ArrayList<City>();

    // getCities method add cities to an ArrayList and returns it.
    public static ArrayList<City> getCities() {

        cities.add(addCity(
                "Chicago",
                "USA",
                "541263/screenshots/3606770/1efe2553451829.59356c47493af_-_kopia.jpg",
                41.881832,
                -87.623177
                )
        );

        cities.add(addCity(
                "New York",
                "USA",
                "2546897/screenshots/5816083/liberty-01-01-01_4x.jpg",
                40.730610,
                -73.935242
                )
        );

        cities.add(addCity(
                "Miami",
                "USA",
                "225954/screenshots/2079577/miami_beach_shot.png",
                25.761681,
                -80.191788
                )
        );

        cities.add(addCity(
                "San Francisco",
                "USA",
                "1499888/screenshots/3348525/ggb-puzzle.png",
                37.733795,
                -122.446747)
        );

        return cities;
    }


    /* addCity method creates and returns a new City object.
    *  It accepts five parameters city name, country name, artwork url, longitude and latitude coordinates.
    *  The artwork url is concatenated with the base url of dribble cdn before returning the object.
    * */
    public static City addCity(String cityName, String countryName, String artworkUrl,
                               double longi, double lati) {

        String dribbleBaseUrl = "https://cdn.dribbble.com/users/";

        return new City(cityName, countryName, dribbleBaseUrl + artworkUrl, longi, lati);
    }
}
