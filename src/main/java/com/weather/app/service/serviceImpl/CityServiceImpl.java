package com.weather.app.service.serviceImpl;


import com.weather.app.dao.City;
import com.weather.app.dao.Weather;
import com.weather.app.repository.CityRepository;
import com.weather.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arman Abrahamyan on 6/14/2019.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;


    @Override
    public List<City> findCityByArea(String area){
     return cityRepository.findByArea(area);
    }


    @Override
    public City findById(int id){
     return cityRepository.findById(id).get();
    }

    @Override
    public City findCityByCity(String name) {
        return cityRepository.findCityByCity(name);
    }

    @Override
    public City save(City city) {
       return cityRepository.save(city);
    }


}
