package com.weather.app.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * @author Arman Abrahamyan on 6/20/2019.
 */

public class Weather {



    //Температура (° С).
    @JsonProperty("temperature")
    private String temperature;

    //Описания погоды.
    @JsonProperty("condition")
    private String condition;

    //Скорость ветра (метров в секунду).
    @JsonProperty("windSpead")
    private double windSpead;

    //Влажность (в процентах).
    @JsonProperty("humidity")
    private int humidity;

    //Атмосферное давление (мм рт. Ст.).
    @JsonProperty("pressureMM")
    private int pressureMM;

    //Атмосферное давление (гПа).
    @JsonProperty("pressurePA")
    private int pressurePA;

    public Weather() {
    }

    public Weather(String temperature, String condition, double windSpead, int humidity, int pressureMM, int pressurePA) {
        this.temperature = temperature;
        this.condition = condition;
        this.windSpead = windSpead;
        this.humidity = humidity;
        this.pressureMM = pressureMM;
        this.pressurePA = pressurePA;
    }

    public Weather temperature(String temperature){
        this.temperature=temperature;
        return this;
    }

    public Weather condition(String condition){
        this.condition=condition;
        return this;
    }

    public Weather windSpead(double windSpead){
        this.windSpead=windSpead;
        return this;
    }

    public Weather humidity(int humidity){
        this.humidity=humidity;
        return this;
    }

    public Weather pressureMM(int pressureMM){
        this.pressureMM=pressureMM;
        return this;
    }

    public Weather pressurePA(int pressurePA){
        this.pressurePA=pressurePA;
        return this;
    }

    public Weather built(){
        return new Weather(temperature,condition,windSpead,humidity,pressureMM,pressurePA);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Double.compare(weather.windSpead, windSpead) == 0 &&
                humidity == weather.humidity &&
                pressureMM == weather.pressureMM &&
                pressurePA == weather.pressurePA &&
                temperature.equals(weather.temperature) &&
                Objects.equals(condition, weather.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, condition, windSpead, humidity, pressureMM, pressurePA);
    }

    @Override
    public String toString() {
        return  '{'+
                "\"temperature\":" + temperature + ',' +
                "\"condition\":" + condition  + ',' +
                "\"windSpead\":" + windSpead + ',' +
                "\"humidity\":" + humidity + ',' +
                "\" pressureMM\":" + pressureMM + ',' +
                "\" pressurePA\":" + pressurePA +
                '}';
    }
}
