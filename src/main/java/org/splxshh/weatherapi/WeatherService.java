package org.splxshh.weatherapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weatherApiKey}")
    private String apiKey;
    public ResponseEntity<String> getWeather(String city){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/{location}?key={your_api_key}";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, city, apiKey );
        return response;
    }
}
