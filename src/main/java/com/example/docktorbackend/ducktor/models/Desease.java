package com.example.docktorbackend.ducktor.models;

import lombok.Data;

@Data
public class Desease {
    private String name;
    private String overview;
    private String symptoms;
    private String cause;
    private String treatment;
    private String diagnosis;
    private String prevention;

    @Override
    public String toString() {
        return "Desease{" +
                "name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", cause='" + cause + '\'' +
                ", treatment='" + treatment + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", prevention='" + prevention + '\'' +
                '}';
    }
}
