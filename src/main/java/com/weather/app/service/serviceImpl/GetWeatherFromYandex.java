package com.weather.app.service.serviceImpl;

import com.weather.app.dao.Weather;
import com.weather.app.enums.Conditions;
import com.weather.app.service.GettingWeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 * @author Arman Abrahamyan on 6/20/2019.
 */
@Service
public class GetWeatherFromYandex implements GettingWeatherService {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Weather getWeather(double latit, double longit) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.weather.yandex.ru/v1/forecast?lat="+latit+"&lon="+longit)).header("X-Yandex-API-Key","d9276341-dc7c-4f33-bf72-91f5502a254e").GET().build();
        String response  = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();

        JSONObject jsonObject = new JSONObject(response);
        System.out.println(jsonObject.getJSONObject("fact").get("temp"));


        return new Weather()
                .temperature(jsonObject.getJSONObject("fact").get("temp").toString())
                .windSpead(Double.valueOf( jsonObject.getJSONObject("fact").get("wind_speed").toString()))
                .humidity( (int)jsonObject.getJSONObject("fact").get("humidity"))
                .condition(Conditions.valueOf(jsonObject.getJSONObject("fact").get("condition").toString().replaceAll("-", "_")).getValue())
                .built();

    }
}
