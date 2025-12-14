package com.sweetshop_backend.service;

import com.sweetshop_backend.model.Sweet;
import com.sweetshop_backend.repository.SweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SweetService {

    private final SweetRepository repo;

    public SweetService(SweetRepository repo) {

        this.repo = repo;
    }
    public Sweet addSweet(Sweet sweet){

        return repo.save(new Sweet(null, "Kaju Katli", "Dry Sweet", 500, 10));
    }
    public List<Sweet> getAll(){
        return repo.findAll();
    }

    public Sweet purchase(String id,int qty){
        Sweet sweet=repo.findById(id).orElseThrow();
        if(sweet.getQuantity()<qty){
            throw new RuntimeException("out of stock");
        }
        sweet.setQuantity(sweet.getQuantity()-qty);
        return repo.save(sweet);
    }
}
