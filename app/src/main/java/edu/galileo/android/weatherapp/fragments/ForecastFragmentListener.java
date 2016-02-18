package edu.galileo.android.weatherapp.fragments;

import edu.galileo.android.weatherapp.model.WeatherInfo;

/**
 * Created by ykro.
 */
public interface ForecastFragmentListener {
    void addToList(WeatherInfo record);
}
