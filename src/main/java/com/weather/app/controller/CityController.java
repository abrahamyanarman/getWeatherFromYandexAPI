package com.weather.app.controller;

import com.weather.app.dao.City;
import com.weather.app.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * This controller is designed to requests for information about the city.
 * @author Arman Abrahamyan on 6/16/2019.
 */
@RestController
public class CityController {




    @Qualifier("cityServiceImpl")
    @Autowired
    CityService cityService;

    /**
     * This method is used to get date from database by id.
     * @param id This is the first parameter.Type is int.
     * @return Return type is String.
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getById(@PathVariable int id){

        return cityService.findById(id).getCity();
    }

    /**
     * This method is used to get date from database by Area.
     * @param area This is the first parameter.Type is String.
     * @return Return type is List.
     */
    @RequestMapping(value = "/area",method = RequestMethod.GET)
    public List<City> getByArea(@RequestParam("area") String area){

       return cityService.findCityByArea(area);

    }

    /**
     * This method is used to get date from database by City(name).
     * @param city This is the first parameter.Type is String.
     * @return Return type is Json.
     */
    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public City getByCity(@RequestParam("city") String city){

        return cityService.findCityByCity(city);

    }
}
