package com.northcoders.demospringbootapp.model;

public record SunInformation(String date, String sunrise, String sunset, String first_light, String last_light, String dawn, String dusk, String solar_noon, String golden_hour, String day_length, String timezone, Integer utc_offset) { }
