package com.sweetshop_backend.repository;

import com.sweetshop_backend.model.Sweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface SweetRepository extends MongoRepository<Sweet,String> {

    List<Sweet> findByNameContainingIgnoreCase(String name);
    List<Sweet> findByCategory(String category);
}
