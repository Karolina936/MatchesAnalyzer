package com.example.match2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competitor {
    private String id;
    private String name;
    private String country;
    private String country_code;
    private String abbreviation;
    private String qualifier;
    private String gender;

    @Override
    public String toString() {
        return name + "(" + country +")";
    }
}
