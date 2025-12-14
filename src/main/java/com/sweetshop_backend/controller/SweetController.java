package com.sweetshop_backend.controller;

import com.sweetshop_backend.model.Sweet;
import com.sweetshop_backend.service.SweetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sweets")
@CrossOrigin
@AllArgsConstructor
public class SweetController {
    private final SweetService service;

    @PostMapping
    public Sweet add(@RequestBody Sweet sweet){
        return service.addSweet(sweet);
    }
    @GetMapping
    public Sweet purchase(@PathVariable String id,@RequestParam int qty){
        return  service.purchase(id,qty);
    }
}
