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

    @RequestMapping("/{productID}")
    public List<CatalogItem> getCatalog(@PathVariable("productID") String productID){


        List<ProductQualityRating> productRatings = Arrays.asList(
                new ProductQualityRating("1001", 10),
                new ProductQualityRating("1002", 9)
        );

        return productRatings.stream().map(rating -> {

           Products products =  restTemplate.getForObject("http://localhost:8081/products/" + rating.getProductID(), Products.class);
                    assert products != null;
                    return new CatalogItem(products.getProductName(), "Computer", products.getProductID());
        })
                .collect(Collectors.toList());

    }

}
