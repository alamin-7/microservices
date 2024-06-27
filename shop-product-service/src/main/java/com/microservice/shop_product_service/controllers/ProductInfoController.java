package com.microservice.shop_product_service.controllers;

import com.microservice.shop_product_service.models.Products;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductInfoController {

    @RequestMapping("/{productID}")
    List<Products> getProducts(@PathVariable("productID") String productID){
        return Collections.singletonList(

                new Products("1001", "Dell")
        );
    }
}
