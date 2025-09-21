package com.example.Fake.Weather.API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class WeatherController {

    private final String[] conditions = {
            "Sunny", "Cloudy", "Rainy", "Windy", "Snowy", "Stormy"
    };

    @GetMapping("/api/weather")
    public Map<String, Object> getWeather(@RequestParam(defaultValue = "Gimhae") String city) {

        Random random = new Random();
        Map<String, Object> response = new HashMap<>();
        response.put("city", city);
        response.put("temperature", random.nextInt(35));
        response.put("condition", conditions[random.nextInt(conditions.length)]);
        response.put("humidity", random.nextInt(100));

        return response;
    }

}
