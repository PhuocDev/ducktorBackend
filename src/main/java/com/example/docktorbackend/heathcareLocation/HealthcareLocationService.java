package com.example.docktorbackend.heathcareLocation;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthcareLocationService {

    public List<String> getIdFromAutoCompleteAPI(String jsonString) {
        List<String> idList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonResults = jsonObject.getJSONArray("results");
        JSONObject segment = jsonResults.getJSONObject(0);
        JSONArray jsonSegment = segment.getJSONArray("segments");

        System.out.println("Number of segments (key word): " + jsonSegment.length());
        for (int i = 0; i < jsonSegment.length(); i++) {
            if(jsonSegment.getJSONObject(i).has("id")) {
                idList.add(jsonSegment.getJSONObject(i).getString("id"));
            }
        }
        return idList;
    }

    public List<HealthCareLocation> getHealthcareLocation(String jsonStringLocation) {
        List<HealthCareLocation> healthCareLocations = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonStringLocation);
        JSONArray jsonArray =jsonObject.getJSONArray("results");

        for (int i = 0; i < jsonArray.length(); i++) {
            String name = jsonArray.getJSONObject(i).getJSONObject("poi").getString("name");
            Address address = new Address();
            address.setStreetNumber(jsonArray.getJSONObject(i).getJSONObject("address").getString("streetNumber"));
            address.setStreetName(jsonArray.getJSONObject(i).getJSONObject("address").getString("streetName"));
            address.setDistrict(jsonArray.getJSONObject(i).getJSONObject("address").getString("municipalitySubdivision"));
            address.setCity(jsonArray.getJSONObject(i).getJSONObject("address").getString("countrySubdivision"));
            Location tempLocation = new Location();
            tempLocation.setLat(jsonArray.getJSONObject(i).getJSONObject("position").getDouble("lat"));
            tempLocation.setLon(jsonArray.getJSONObject(i).getJSONObject("position").getDouble("lon"));
            HealthCareLocation healthCareLocation = new HealthCareLocation();
            healthCareLocation.setName(name);
            healthCareLocation.setLocation(tempLocation);
            healthCareLocation.setAddress(address);
            healthCareLocations.add(healthCareLocation);
        }

        return healthCareLocations;
    }
//- name: string
//- address: string
//    - street_number: string
//    - street_name: string
//    - district: string
//    - city: string
//- location
//    - lat: double
//    - lon: double

}
