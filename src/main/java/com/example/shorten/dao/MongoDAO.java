package com.example.shorten.dao;

import com.example.shorten.model.Link;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class MongoDAO {

    @Autowired
    MongoTemplate mongoTemplate;

    //todo add optional
    @Transactional
    public String getLongLink(String shortLink) {
        Query query = new Query();
        query.addCriteria(Criteria.where("shortLink").is(shortLink));

        //todo redirect counts
        Link longLink = mongoTemplate.findOne(query, Link.class);
        if (longLink != null) {
            return longLink.getLongLink();
        }
        return "oops";

    }
}
