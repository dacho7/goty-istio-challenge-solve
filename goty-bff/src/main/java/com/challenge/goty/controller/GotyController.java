package com.challenge.goty.controller;

import com.challenge.goty.service.GotyService;
import com.challenge.goty.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/goty")
public class GotyController {

    @Autowired
    private GotyService gotyService;

    @GetMapping("/products")
    public Mono<List<Product>> getAllProducts() {
        return gotyService.getAllProducts();
    }


    @GetMapping("/similars/{id}")
    public Mono<List<Product>> getProductAndSimilars(@PathVariable int id) {
        return gotyService.getSimilarProducts(id);
    }
}
