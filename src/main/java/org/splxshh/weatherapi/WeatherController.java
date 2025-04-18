package org.splxshh.weatherapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //defines class as a controller and includes @responsebody
@RequestMapping("weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam String city){
        ResponseEntity<String> response = weatherService.getWeather(city);
        if (response.getStatusCode().is2xxSuccessful()){
            return ResponseEntity.ok(response.getBody());
        }else {
            return ResponseEntity
                    .status(response.getStatusCode())
                    .body("Something went wrong with the weather API.");
        }
    }

}
