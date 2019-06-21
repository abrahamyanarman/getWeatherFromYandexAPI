package com.weather.app.repository;

import com.weather.app.dao.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Arman Abrahamyan on 6/14/2019.
 */
@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Query(value = "SELECT * FROM weather WHERE weather.area =?1", nativeQuery = true)
    List<City> findByArea(String area);


    @Query(value = "SELECT * FROM weather WHERE weather.city =?1", nativeQuery = true)
    City findCityByCity (String city);


}
