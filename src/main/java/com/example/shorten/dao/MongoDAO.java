package com.example.shorten.dao;

import com.example.shorten.model.Link;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

        Update update = new Update();
        update.inc("redirectCount");
        Link longLink = mongoTemplate.findAndModify(query, update, Link.class);
        if (longLink != null) {
            return longLink.getLongLink();
        }
        return "oops";

    }

    public String getStatistics(String shortLink) {
        Query query = new Query();
        query.addCriteria(Criteria.where("shortLink").is(shortLink));

        List<Link> links = mongoTemplate.find(query, Link.class);
        if (links.size() != 0){
            return String.valueOf(links.get(0).getRedirectCount());
        } else {
            return "No such link";
        }
    }
}
