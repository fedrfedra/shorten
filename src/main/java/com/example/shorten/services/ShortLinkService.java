package com.example.shorten.services;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkService {

    @Autowired
    Faker faker;

    public String getShortLink(){
        return getRandomLink();
    }

    public String getRandomLink(){
        return faker.twinPeaks().character();
    }
}
