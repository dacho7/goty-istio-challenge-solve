package com.challenge.goty.controller;

import com.challenge.goty.service.GotyService;
import com.challenge.goty.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/goty")
public class GotyController {

    @Autowired
    private GotyService gotyService;

    @GetMapping("/products")
    public Mono<List<Product>> getAllProducts() {
        System.out.println("request in /products");
        return gotyService.getAllProducts();
    }


    @GetMapping("/similars/{id}")
    public Mono<List<Product>> getProductAndSimilars(@PathVariable int id) {
        System.out.println("request in /similars/{id}");
        return gotyService.getSimilarProducts(id);
    }
}
