package com.example.shorten.services;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KGSService {

    //todo add constants
    @Autowired
    Faker faker;

    @Autowired
    RestTemplate restTemplate;

    public String getShortLink() {
        return restTemplate.getForObject("http://localhost:8081/api/get_short_link", String.class);
    }

    public String postShortLink(String customShortLink) {
        HttpEntity<String> request = new HttpEntity<>(customShortLink);
        return restTemplate.postForObject("http://localhost:8081/api/post_short_link", request, String.class);
    }

}
