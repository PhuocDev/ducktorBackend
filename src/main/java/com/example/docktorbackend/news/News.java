package com.example.docktorbackend.news;

import lombok.Data;

@Data
public class News {
    private String title;
    private String description;
    private String url;
    private String urlToImage;
}
