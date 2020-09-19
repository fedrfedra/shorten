package com.example.shorten.services;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KGSService {

    @Autowired
    Faker faker;

    @Autowired
    RestTemplate restTemplate;

    public String getShortLink(){
        return restTemplate.getForObject("http://localhost:8081/api/get_short_link", String.class);
    }

    public String getRandomLink(){
        return faker.twinPeaks().character();
    }
}
