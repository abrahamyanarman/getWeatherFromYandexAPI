package com.weather.app.enums;

/**
 * This enum is only designed to work with Yandex weather API .
 * Adapted from response of API.
 * @author Arman Abrahamyan on 6/20/2019.
 */
public enum Conditions {

    clear ("Ясно."),
    cloudy ("Ясно."),
    overcast ("Ясно."),
    partly_cloudy_and_light_rain("Небольшой дождь"),
    partly_cloudy_and_rain("Rain."),
    overcast_and_rain("Сильный дождь."),
    cloudy_and_light_rain("Небольшой дождь"),
    overcast_and_light_rain("Сильный дождь"),
    cloudy_and_rain("Дождь."),
    overcast_and_wet_snow ("Мокрый."),
    partly_cloudy_and_light_snow("Легкий снег."),
    partly_cloudy_and_snow("Снег."),

    overcast_and_snow("Снегопад.");



    private final String value;

    Conditions(String value) {
        this.value = value;
    }



    public String getValue() {
        return value;
    }
}
