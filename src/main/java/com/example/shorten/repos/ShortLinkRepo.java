package com.example.shorten.repos;

import com.example.shorten.model.ShortLink;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShortLinkRepo extends MongoRepository<ShortLink, String> {
}
