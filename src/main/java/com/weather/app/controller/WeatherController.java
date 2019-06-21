package com.weather.app.controller;

import com.weather.app.dao.Weather;
import com.weather.app.service.GettingWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller is designed to monitor weather requests.
 * @author Arman Abrahamyan on 6/20/2019.
 *
 */
@RestController
public class WeatherController {



    @Autowired
    @Qualifier(value = "getWeatherFromYandex")
    GettingWeatherService gettingWeatherService;


    /**
     * This method is used to obtain weather data.
     * The data is obtained from Yandex weather API using geometric data.
     * @param latit This is the first paramter latitude.Type is double
     * @param longit This is the second parameter longitude.Type is double
     * @return json.
     */
    @RequestMapping(value = "/weather",method = RequestMethod.GET)
    public Weather getWeather(@RequestParam double latit, @RequestParam double longit){

        Weather weather= gettingWeatherService.getWeather(latit,longit);
        System.out.println(weather.toString());
        return weather;

    }
}
