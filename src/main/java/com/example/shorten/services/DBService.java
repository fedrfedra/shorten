package com.example.shorten.services;

import com.example.shorten.dao.MongoDAO;
import com.example.shorten.model.Link;
import com.example.shorten.repos.LinkRepo;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;


@Service
public class DBService {

    @Autowired
    LinkRepo repo;

    @Autowired
    Faker faker;

    @Autowired
    KGSService shortLinkService;

    @Autowired
    MongoDAO dao;



    @SneakyThrows
    public String saveLink(String linkString) {
        String shortLink = shortLinkService.getShortLink();
        Link builtLink = Link.builder().shortLink(shortLink).longLink(linkString)
                .creatorName(faker.twinPeaks().character()).redirectCount(6).build();
        repo.save(builtLink);
        URI uri = new URI("http://localhost:8080/");
        return uri.resolve(shortLink).toString();
    }



}
