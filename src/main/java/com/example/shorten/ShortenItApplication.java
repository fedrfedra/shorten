package com.example.shorten;


import com.example.shorten.services.DBService;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ShortenItApplication {

    @Bean
    public Faker faker(){
        return new Faker();
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShortenItApplication.class, args);
    }

}