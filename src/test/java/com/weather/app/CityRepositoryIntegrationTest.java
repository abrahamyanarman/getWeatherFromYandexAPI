package com.weather.app;

import com.weather.app.dao.City;
import com.weather.app.repository.CityRepository;
import com.weather.app.service.CityService;
import com.weather.app.service.serviceImpl.CityServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Arman Abrahamyan on 6/15/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryIntegrationTest {

    @Mock
    private static CityRepository cityRepository;

    @InjectMocks
    private static CityService cityService = new CityServiceImpl();

    private City city;

    @Test
    public void whenIndexIsValid_thenCityShouldBeFound(){
        String cityName = "city";

        city = new City();
        city.setArea(cityName);
        city.setCity(cityName);
        city.setLatitude(11.55);
        city.setLongitude(22.22);

        Mockito.when(cityRepository.findCityByCity(cityName)).thenReturn(city);

        City testCity = cityService.findCityByCity(cityName);

        Assert.assertEquals(city,testCity);

    }

}
