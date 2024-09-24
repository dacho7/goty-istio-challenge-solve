package com.challenge.goty.service;

import com.challenge.goty.service.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GotyService {
    private final WebClient webClient;

    public GotyService(@Value("${backend.url.base}") String baseUrl) {
        System.out.println("url base " + baseUrl);
        this.webClient = WebClient.create(baseUrl); // URL base
    }

    public Mono<List<Product>> getAllProducts() {
        return webClient.get()
                .uri("/api/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList();
    }

    public Mono<List<Product>> getSimilarProducts(int productId) {
        return webClient.get()
                .uri("/api/product/{id}/similars", productId)
                .retrieve()
                .bodyToMono(Integer[].class)
                .flatMapMany(Flux::fromArray)
                .flatMap(this::getProductById)
                .collectList();
    }

    private Mono<Product> getProductById(int productId) {
        return webClient.get()
                .uri("/api/product/{id}", productId)
                .retrieve()
                .bodyToMono(Product.class);
    }
}
