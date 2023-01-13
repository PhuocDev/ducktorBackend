package com.example.docktorbackend.covid_information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/covid")
public class CovidController {
    @Autowired
    CovidService covidService;

    @GetMapping("/vietnam/get-summary")
    public Covid getVietnamSummary() {
        Covid vietnamSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();

        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        vietnamSummary = covidService.getVietNamSummary(jsonObject);
        return vietnamSummary;
    }
    @GetMapping("/global/get-summary")
    public Covid getGlobalSummary() {
        Covid globalSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        globalSummary = covidService.getGlobalSummary(jsonObject);
        return globalSummary;
    }
    @GetMapping("/vietnam/get-total-recovered")
    public Map<String, Object> getVNTotalRecovered() {
        Covid vietnamSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        vietnamSummary = covidService.getVietNamSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", vietnamSummary.getRecoveredTotal());
        return map;
    }
    @GetMapping("/vietnam/get-today-recovered")
    public Map<String, Object> getVNTodayRecovered() {
        Covid vietnamSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        vietnamSummary = covidService.getVietNamSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", vietnamSummary.getRecoveredInDay());
        return map;
    }
    @GetMapping("/vietnam/get-total-death")
    public Map<String, Object> getVNTotalDeath() {
        Covid vietnamSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        vietnamSummary = covidService.getVietNamSummary(jsonObject);
        System.out.println(vietnamSummary.getDeathTotal());
        Map<String, Object> map = new HashMap<>();
        map.put("result", vietnamSummary.getDeathTotal());
        return map;
    }
    @GetMapping("/vietnam/get-today-death")
    public Map<String, Object> getVNTodayDeath() {
        Covid vietnamSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        vietnamSummary = covidService.getVietNamSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", vietnamSummary.getDeathInDay());
        return map;
    }
    @GetMapping("/vietnam/get-total-infected")
    public Map<String, Object> getTotalInfected() {
        Covid vietnamSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        vietnamSummary = covidService.getVietNamSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", vietnamSummary.getInfectedTotal());
        return map;
    }
    @GetMapping("/vietnam/get-today-infected")
    public Map<String, Object> getTodayInfected() {
        Covid vietnamSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        vietnamSummary = covidService.getVietNamSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", vietnamSummary.getInfectedInDay());
        return map;
    }
    @GetMapping("/global/get-total-recovered")
    public Map<String, Object> getGlobalTotalRecovered() {
        Covid globalSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        globalSummary = covidService.getGlobalSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", globalSummary.getRecoveredTotal());
        return map;
    }
    @GetMapping("/global/get-today-recovered")
    public Map<String, Object> getGlobalTodayRecovered() {
        Covid globalSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        globalSummary = covidService.getGlobalSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", globalSummary.getRecoveredInDay());
        return map;
    }
    @GetMapping("/global/get-total-death")
    public Map<String, Object> getGlobalTotalDeath() {
        Covid globalSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        globalSummary = covidService.getGlobalSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", globalSummary.getDeathTotal());
        return map;
    }
    @GetMapping("/global/get-today-death")
    public Map<String, Object> getGlobalTodayDeath() {
        Covid globalSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        globalSummary = covidService.getGlobalSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", globalSummary.getDeathInDay());
        return map;
    }
    @GetMapping("/global/get-today-infected")
    public Map<String, Object> getGlobalTodayInfected() {
        Covid globalSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        globalSummary = covidService.getGlobalSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", globalSummary.getInfectedInDay());
        return map;
    }
    @GetMapping("/global/get-total-infected")
    public Map<String, Object> getGlobalTotalInfected() {
        Covid globalSummary = new Covid();
        String uri = "https://api.covid19api.com/summary";
        RestTemplate restTemplate = new RestTemplate();
        //get Json from api
        String jsonObject = restTemplate.getForObject(uri, String.class);

        globalSummary = covidService.getGlobalSummary(jsonObject);
        Map<String, Object> map = new HashMap<>();
        map.put("result", globalSummary.getInfectedTotal());
        return map;
    }



}
