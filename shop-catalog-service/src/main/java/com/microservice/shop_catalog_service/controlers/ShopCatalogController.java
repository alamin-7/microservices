package com.microservice.shop_catalog_service.controlers;

import com.microservice.shop_catalog_service.models.CatalogItem;
import com.microservice.shop_catalog_service.models.ProductQualityRating;
import com.microservice.shop_catalog_service.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class ShopCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{productID}")
    public List<CatalogItem> getCatalog(@PathVariable("productID") String productID){


        List<ProductQualityRating> productRatings = Arrays.asList(
                new ProductQualityRating("1001", 10),
                new ProductQualityRating("1002", 9)
        );

        return productRatings.stream().map(rating -> {

            Products [] products = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8081/products/" + rating.getProductID())
                    .retrieve()
                    .bodyToMono(Products[].class)
                    .block();

                    return new CatalogItem(products[0].getProductName(), "Computer", products[0].getProductID());
        })
                .distinct()
                .collect(Collectors.toList());

    }

}
