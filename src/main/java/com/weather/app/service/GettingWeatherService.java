package com.weather.app.service;

import com.weather.app.dao.Weather;

/**
 * @author Arman Abrahamyan on 6/20/2019.
 */
public interface GettingWeatherService {


    Weather getWeather(double latit, double longit);
}
