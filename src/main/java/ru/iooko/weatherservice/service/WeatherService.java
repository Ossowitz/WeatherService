package ru.iooko.weatherservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.iooko.weatherservice.model.Weather;

import java.util.Optional;

@Service
public class WeatherService {

    @Value("${weatherapi.key}")
    private String apiKey;

    public Optional<Weather> getWeather(String city) {
        String url = String.format("http://api.weatherapi.com/v1/current.json?key=%s&q=%s", apiKey, city);
        RestTemplate restTemplate = new RestTemplate();

        Weather weatherResponse = restTemplate.getForObject(url, Weather.class);

        return Optional.ofNullable(weatherResponse)
                .map(it -> new Weather(
                        it.getLocation(),
                        it.getCurrent()
                ));
    }
}
