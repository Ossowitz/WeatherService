package ru.iooko.weatherservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.iooko.weatherservice.model.Location;

import java.util.Optional;

@Service
public class LocationService {

    public Optional<String> getCityByIp(String ip) {
        String url = String.format("http://ip-api.com/json/%s", ip);
        RestTemplate restTemplate = new RestTemplate();

        Location locationResponse = restTemplate.getForObject(url, Location.class);

        return Optional.ofNullable(locationResponse)
                .map(Location::getCity);
    }
}
