package com.example.docktor_mobile.ducktor.services;

import com.example.docktor_mobile.ducktor.models.Desease;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class DeseaseService {
    public Desease getInformationFromJson(String jsonString) {
        Desease desease = new Desease();
        JSONObject jsonObject = new JSONObject(jsonString);

        //JSONObject hasPart = jsonObject.getString("hasPart");
        JSONArray hasPart = jsonObject.getJSONArray("hasPart");
        System.out.println("hasPart size = " + hasPart.length());
        for (int i = 0; i < hasPart.length(); i++) {
            String hasPartUrl = hasPart.getJSONObject(i).getString("hasHealthAspect");
            String description = hasPart.getJSONObject(i).getString("description");
            if (hasPartUrl.contains("Overview") || hasPartUrl.contains("overview")) {
                desease.setOverview(description);
            } else if (hasPartUrl.contains("Prevention")) {
                desease.setPrevention(description);
            } else if (hasPartUrl.contains("Diagnosis")) {
                desease.setDiagnosis(description);
            } else if (hasPartUrl.contains("Symptom")) {
                desease.setSymptoms(description);
            } else if (hasPartUrl.contains("Treatment") || hasPartUrl.contains("SelfCare")) {
                desease.setTreatment(description);
            } else if (hasPartUrl.contains("Cause")) {
                desease.setCause(description);
            }
            System.out.println(hasPartUrl + "\n" + description);
        }
        desease.setName(jsonObject.getString("name"));
        return desease;
    }
}
