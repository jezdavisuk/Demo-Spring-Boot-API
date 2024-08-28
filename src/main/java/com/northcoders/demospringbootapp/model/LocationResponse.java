package com.northcoders.demospringbootapp.model;

import java.util.ArrayList;

public record LocationResponse(ArrayList<Location> results, String generationtime_ms) {
}
