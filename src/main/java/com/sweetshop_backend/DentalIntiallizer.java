package com.sweetshop_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;

public class DentalIntiallizer implements CommandLineRunner {
    private final MongoTemplate mongoTemplate;

    public DentalIntiallizer(MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;
    }
    @Override
    public void run(String... args) {
        if (!mongoTemplate.collectionExists("test_collection")) {
            mongoTemplate.createCollection("test_collection");
        }
    }
}
