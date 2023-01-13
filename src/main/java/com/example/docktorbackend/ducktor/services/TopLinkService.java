package com.example.docktorbackend.ducktor.services;

import com.example.docktorbackend.ducktor.models.TopLink;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TopLinkService {
    public ArrayList<TopLink> getLinksFromJson(String jsonString) {
        ArrayList<TopLink> topLinks = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray significantLinks = jsonObject.getJSONArray("significantLink");
        System.out.println("Number of significantLinks: " + significantLinks.length());
        for (int i = 0; i < significantLinks.length(); i++) {
            TopLink topLink = new TopLink();
            topLink.setName(((JSONObject) significantLinks.get(i)).getString("name"));
            topLink.setDescription(((JSONObject) significantLinks.get(i)).getString("description"));
            topLink.setUrl(((JSONObject) significantLinks.get(i)).getString("url"));
            System.out.println(topLink);
            topLinks.add(topLink);
        }

        return topLinks;
    }

}
