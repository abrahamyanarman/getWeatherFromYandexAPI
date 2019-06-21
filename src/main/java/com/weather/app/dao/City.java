package com.weather.app.dao;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Arman Abrahamyan on 6/14/2019.
 */
@Entity
@Table(name = "weather")
public class City {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index")
    private int index;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private String city;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    public City() {
    }

    public City(String area, String city, double latitude, double longitude) {
        this.area = area;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return index == city1.index &&
                Double.compare(city1.latitude, latitude) == 0 &&
                Double.compare(city1.longitude, longitude) == 0 &&
                Objects.equals(area, city1.area) &&
                Objects.equals(city, city1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, area, city, latitude, longitude);
    }

    @Override
    public String toString() {
        return "City{" +
                "index=" + index +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
