package ru.iooko.weatherservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.iooko.weatherservice.service.LocationService;
import ru.iooko.weatherservice.service.WeatherService;

import java.util.Optional;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/weather")
    public String weather(@RequestHeader(value = "X-Forwarded-For", required = false) String xForwardedFor,
                          HttpServletRequest request,
                          Model model) {
        String ipAddress = Optional.ofNullable(xForwardedFor)
                .filter(s -> !s.isEmpty())
                .map(s -> s.split(",")[0])
                .orElse(request.getRemoteAddr());

        locationService.getCityByIp(ipAddress)
                .ifPresentOrElse(city -> weatherService.getWeather(city)
                                .ifPresentOrElse(weather -> {
                                    model.addAttribute("city", weather.getLocation().getName());
                                    model.addAttribute("temperature", weather.getCurrent().getTemperature());
                                    model.addAttribute("condition", weather.getCurrent().getCondition().getText());
                                }, () -> model.addAttribute("error", "Weather data not available for " + city)),
                        () -> model.addAttribute("error", "City not found for IP: " + ipAddress));

        return "weather";
    }
}
