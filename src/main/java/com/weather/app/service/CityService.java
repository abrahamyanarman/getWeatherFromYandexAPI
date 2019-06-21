package com.weather.app.service;

import com.weather.app.dao.City;

import java.util.List;

/**
 * @author Arman Abrahamyan on 6/15/2019.
 */
public interface CityService {
     List<City> findCityByArea(String area);

     City findById(int id);

     City findCityByCity(String name);


     City save(City city);






}
