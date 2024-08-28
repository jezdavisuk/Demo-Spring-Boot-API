package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.api_helpers.GenericDAO;
import com.northcoders.demospringbootapp.model.Location;
import com.northcoders.demospringbootapp.model.LocationResponse;
import com.northcoders.demospringbootapp.model.SunInformation;
import com.northcoders.demospringbootapp.model.SunInformationResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController()
@RequestMapping("api/v1")
public class DemoController {

    @GetMapping("/test")
    private String testMapping() {
        return "<html><body><h1>Test!</h1></body></html>";
    }

    @GetMapping("/hello")
    private String getHello() {
        return "<html><img src=\"https://media.tenor.com/WuOwfnsLcfYAAAAC/star-wars-obi-wan-kenobi.gif\" /></html>";
    }

    @GetMapping("/search/location/{searchCity}")
    private ArrayList<Location> getLocationInfo(@PathVariable String searchCity) {
        String jsonResponse = GenericDAO.getJsonResponse(
                "https://geocoding-api.open-meteo.com/v1/search",
                new String[] {"name=" + searchCity, "count=2", "language=en", "format=json"},
                new String[] {});

        Optional<LocationResponse> response = GenericDAO.mapJsonToPojo(jsonResponse, LocationResponse.class);

        return response.get().results();
    }

    @GetMapping("/search/location/sunrise_sunset/{searchCity}")
    private SunInformation getSunriseSunsetInfo(@PathVariable String searchCity) {
        String latitude = "";
        String longitude = "";

        ArrayList<Location> locationInfoList = getLocationInfo(searchCity);
        Location locationInfo = locationInfoList.get(0);
        latitude = locationInfo.latitude();
        longitude = locationInfo.longitude();

        String jsonResponse = GenericDAO.getJsonResponse(
                "https://api.sunrisesunset.io/json",
                new String[] {"lat=" + latitude, "lng=" + longitude},
                new String[] {});

        Optional<SunInformationResponse> response = GenericDAO.mapJsonToPojo(jsonResponse, SunInformationResponse.class);

        return response.get().results();
    }
}
