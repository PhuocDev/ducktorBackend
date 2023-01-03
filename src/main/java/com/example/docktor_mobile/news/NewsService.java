package com.example.docktor_mobile.news;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    public List<News> getTopNews(String jsonString) {
        List<News> newsList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("articles");

        for (int i = 0; i < Math.min(5, jsonArray.length()); i++) {
            News tempNews = new News();
            tempNews.setTitle(jsonArray.getJSONObject(i).getString("title"));
            tempNews.setUrl(jsonArray.getJSONObject(i).getString("url"));
            tempNews.setDescription(jsonArray.getJSONObject(i).getString("description"));
            tempNews.setUrlToImage(jsonArray.getJSONObject(i).getString("urlToImage"));
            newsList.add(tempNews);
        }
        return newsList;
    }

}
