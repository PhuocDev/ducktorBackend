package com.example.docktorbackend.heathcareLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ducktor")
public class HealthcareLocationController {
    @Autowired
    HealthcareLocationService healthcareService;

    @GetMapping("/nearbyCenter")
    public List<HealthCareLocation> getNearbyHealthcareCenter(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam String userInput
            ) {
        List<HealthCareLocation> healthCareLocations = new ArrayList<>();
        String keyAutoComplete = "jzDBzob4W8SkTPtVSfBnzerrAetQh55G";
        String uri = "https://api.tomtom.com/search/2/autocomplete/" +
                userInput + ".json?" +
                "key=" + keyAutoComplete +
                "&language=en-US";
        List<String> idListFromAutocompleteAPI;
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject(uri, String.class);
        idListFromAutocompleteAPI = healthcareService.getIdFromAutoCompleteAPI(jsonString);
        String categorySets = String.join(",", idListFromAutocompleteAPI);
        System.out.println(categorySets);
        String uri2 = "https://api.tomtom.com/search/2/nearbySearch/.json" +
                "?key=jzDBzob4W8SkTPtVSfBnzerrAetQh55G" +
                "&lat="+ String.valueOf(lat) +
                "&lon= "+String.valueOf(lon) +
                "&categorySet=" + categorySets +
                "&limit=5";
        RestTemplate restTemplate1 = new RestTemplate();
        String jsonStringLocation = restTemplate1.getForObject(uri2, String.class);
        healthCareLocations = healthcareService.getHealthcareLocation(jsonStringLocation);
        return healthCareLocations;
    }
    @GetMapping("/nearbyTest")
    public List<HealthCareLocation> getNearbyHealthcareCenterTest(
    ) {
        List<HealthCareLocation> healthCareLocations = new ArrayList<>();
        String uriFake = "https://api.tomtom.com/search/2/autocomplete/find nearby hospital and healthcare center.json?key=jzDBzob4W8SkTPtVSfBnzerrAetQh55G&language=en-US";

        List<String> idListFromAutocompleteAPI;
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject(uriFake, String.class);

        idListFromAutocompleteAPI = healthcareService.getIdFromAutoCompleteAPI(jsonString);
        idListFromAutocompleteAPI.forEach(System.out::println);

        String uri2Fake = "https://api.tomtom.com/search/2/nearbySearch/.json?key=jzDBzob4W8SkTPtVSfBnzerrAetQh55G&lat=10.776918&lon=106.617288&categorySet=7321002&limit=5";
        RestTemplate restTemplate1 = new RestTemplate();
        String jsonStringLocation = restTemplate1.getForObject(uri2Fake, String.class);
        healthCareLocations = healthcareService.getHealthcareLocation(jsonStringLocation);

        return healthCareLocations;
    }


}
