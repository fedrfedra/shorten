package com.example.shorten;


import com.example.shorten.services.DBService;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class ShortenItApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Faker faker() {
        return new Faker();
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShortenItApplication.class, args);
    }

}
