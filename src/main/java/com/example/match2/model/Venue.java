package com.example.match2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
    private String id;
    private String name;
    private int capacity;
    private String city_name;
    private String country_name;
    private String map_coordinates;
    private String country_code;

    @Override
    public String toString() {
        return "Venue: " + name;
    }
}
