package com.example.weatherapp;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class WeatherActivityTest {

    @Rule
    public ActivityTestRule<WeatherActivity> activityActivityTestRule = new ActivityTestRule<WeatherActivity>(WeatherActivity.class);

    private WeatherActivity weatherActivity = null;

    @Before
    public void setUp() throws Exception {
        weatherActivity = activityActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        // Get Views and check if not null
        View viewTemp = weatherActivity.findViewById(R.id.temp);
        assertNotNull(viewTemp);

        View viewUnit = weatherActivity.findViewById(R.id.unit);
        assertNotNull(viewUnit);

        View viewDate = weatherActivity.findViewById(R.id.date);
        assertNotNull(viewDate);

        View viewCity = weatherActivity.findViewById(R.id.name);
        assertNotNull(viewCity);

        View viewInfo = weatherActivity.findViewById(R.id.info);
        assertNotNull(viewInfo);

        View viewRecycler = weatherActivity.findViewById(R.id.weather_recycler);
        assertNotNull(viewRecycler);
    }

    @After
    public void tearDown() throws Exception {
        weatherActivity = null;
    }
}