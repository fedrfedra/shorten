package com.example.shorten.services;

import com.example.shorten.dao.MongoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedirectService {

    @Autowired
    MongoDAO dao;


    public String getLongLink(String shortLink){
        return dao.getLongLink(shortLink);
    }

}
