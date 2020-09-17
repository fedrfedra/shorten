package com.example.shorten.services;

import com.example.shorten.model.Link;
import com.example.shorten.repos.LinkRepo;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class DBService {

    @Autowired
    LinkRepo repo;

    @Autowired
    Faker faker;

    @Autowired
    ShortLinkService shortLinkService;

    @Transactional
    public void saveLink(String linkString) {
        Link builtLink = Link.builder().shortLink(shortLinkService.getShortLink()).longLink(linkString)
                .creatorName(faker.twinPeaks().character()).redirectCount(6).build();
        repo.save(builtLink);

    }

    @Transactional
    public List<Link> findAllLinks() {
        return repo.findAll();
    }

}
