package com.example.shorten.services;

import com.example.shorten.dao.MongoDAO;
import com.example.shorten.model.Link;
import com.example.shorten.repos.LinkRepo;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.net.URI;
import java.util.Objects;


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

    //todo usage of varargs
    @SneakyThrows
    public String saveLink(String longLink, String customShortLink) {
        String shortLink = (customShortLink != null && customShortLink.length() != 0) ?
                shortLinkService.postShortLink(customShortLink)
                :
                shortLinkService.getShortLink();
        Link builtLink = Link.builder().shortLink(shortLink).longLink(longLink)
                .creatorName(faker.twinPeaks().character()).redirectCount(0).build();
        repo.save(builtLink);
        URI uri = new URI("http://localhost:8080/");
        return uri.resolve(shortLink).toString();
    }


    public String getStatistics(String shortLink) {
        return dao.getStatistics(shortLink);
    }
}
