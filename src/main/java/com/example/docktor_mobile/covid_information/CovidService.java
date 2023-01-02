package com.example.docktor_mobile.covid_information;

import com.example.docktor_mobile.ducktor.models.Desease;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CovidService {

    public Covid getVietNamSummary(String jsonString) {
        Covid vietnamSummary = new Covid();
        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray jsonArray = jsonObject.getJSONArray("Countries");
        System.out.println("Number of countries: " + jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            String country = jsonArray.getJSONObject(i).getString("CountryCode");
//            System.out.println(country);
//            System.out.println(jsonArray.getJSONObject(i).getInt("TotalDeaths"));
            if (country.equals("VN")) {
                vietnamSummary.setDeathTotal(jsonArray.getJSONObject(i).getInt("TotalDeaths"));
                vietnamSummary.setDeathInDay(jsonArray.getJSONObject(i).getInt("NewDeaths"));
                vietnamSummary.setInfectedTotal(jsonArray.getJSONObject(i).getInt("TotalConfirmed"));
                vietnamSummary.setInfectedInDay(jsonArray.getJSONObject(i).getInt("NewConfirmed"));
                vietnamSummary.setRecoveredInDay(jsonArray.getJSONObject(i).getInt("NewRecovered"));
                vietnamSummary.setRecoveredTotal(jsonArray.getJSONObject(i).getInt("TotalRecovered"));
            }
        }
        return vietnamSummary;
    }
    public Covid getGlobalSummary(String jsonString) {
        Covid globalSummary = new Covid();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject global = jsonObject.getJSONObject("Global");
                globalSummary.setDeathTotal(global.getInt("TotalDeaths"));
                globalSummary.setDeathInDay(global.getInt("NewDeaths"));
                globalSummary.setInfectedTotal(global.getInt("TotalConfirmed"));
                globalSummary.setInfectedInDay(global.getInt("NewConfirmed"));
                globalSummary.setRecoveredInDay(global.getInt("NewRecovered"));
                globalSummary.setRecoveredTotal(global.getInt("TotalRecovered"));
        return globalSummary;
    }
}
