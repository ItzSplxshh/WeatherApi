package org.splxshh.weatherapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //defines class as a controller and includes @responsebody
@RequestMapping("weather")
public class Controller {
    @GetMapping("/test")
    public String test(){
        return "The Weather API is live!";
    }

}
