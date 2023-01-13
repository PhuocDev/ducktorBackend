package com.example.docktorbackend.heathcareLocation;

import lombok.Data;


@Data
public class HealthCareLocation {
    private String name;
    private Address address;
    private Location location;

}
