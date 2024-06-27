package com.microservice.shop_product_quality_service.controllers;

import com.microservice.shop_product_quality_service.models.ProductQualityRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class ProductRatingController{

    @RequestMapping("/{productID}")
    List<ProductQualityRating> getProductRating(@PathVariable ("productID") String productID){

        return Collections.singletonList(
                new ProductQualityRating(productID, 1 )
        );
    }

}
