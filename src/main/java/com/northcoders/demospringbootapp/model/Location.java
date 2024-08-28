package com.northcoders.demospringbootapp.model;

import java.util.ArrayList;

public record Location(
        Integer id,
        String name,
        String latitude,
        String longitude,
        String elevation,
        Integer population,
        String timezone,
        String admin1_id,
        String admin2_id,
        String admin3_id,
        String admin4_d,
        String feature_code,
        String country_code,
        ArrayList<String> postcodes,
        String country_id,
        String country,
        String admin1,
        String admin2,
        String admin3,
        String admin4) {
}
