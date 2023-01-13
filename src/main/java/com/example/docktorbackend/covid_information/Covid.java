package com.example.docktorbackend.covid_information;

import lombok.Data;

@Data
public class Covid {
    private int deathInDay;
    private int deathTotal;
    private int infectedInDay;
    private int infectedTotal;
    private int recoveredInDay;
    private int recoveredTotal;


    public Covid(){

    }

    public Covid(int deathInDay, int deathTotal, int infectedInDay, int infectedTotal, int recoveredInDay, int recoveredTotal) {
        this.deathInDay = deathInDay;
        this.deathTotal = deathTotal;
        this.infectedInDay = infectedInDay;
        this.infectedTotal = infectedTotal;
        this.recoveredInDay = recoveredInDay;
        this.recoveredTotal = recoveredTotal;
    }

}

//  "death_in_day": 2587,
//          "death_total": 6611892,
//          "infected_in_day": 469555,
//          "infected_total": 635333213,
//          "recovered_in_day": 0,
//          "recovered_total": 0