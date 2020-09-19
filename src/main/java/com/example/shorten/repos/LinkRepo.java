package com.example.shorten.repos;


import com.example.shorten.model.Link;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface LinkRepo extends MongoRepository<Link, String> {


}
