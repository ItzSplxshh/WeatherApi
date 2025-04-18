package org.splxshh.weatherapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class Service {
    @Value("${weatherApiKey}")
    private String apiKey;
    public void getWeather(String city){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/{location}?key={your_api_key}";
        restTemplate.getForObject(url, String.class, city, apiKey );
    }
}
