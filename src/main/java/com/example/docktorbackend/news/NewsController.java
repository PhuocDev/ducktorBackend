package com.example.docktorbackend.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping
    public List<News> getTopNews() {
        List<News> topNews = new ArrayList<>();
        LocalDate to = java.time.LocalDate.now();
        LocalDate from = LocalDate.now().minusDays(2);
        String uri = "https://newsapi.org/v2/everything" +
                "?q=healthcare, disease, medical, covid, health, mental" +
                "&apiKey=971261d012494f5cb8811df9589f1cd3" +
                "&from=" +
                from +
                "&to=" +
                to;
        RestTemplate restTemplate = new RestTemplate();

        //get Json from api
        String jsonString = restTemplate.getForObject(uri, String.class);
        topNews = newsService.getTopNews(jsonString);
        return topNews;
    }

}
