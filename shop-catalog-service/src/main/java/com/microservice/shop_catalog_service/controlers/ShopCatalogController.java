package com.microservice.shop_catalog_service.controlers;

import com.microservice.shop_catalog_service.models.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class ShopCatalogController {

    @RequestMapping("/{productID}")
    public List<CatalogItem> getCatalog(@PathVariable("productID") String productID){
        return Collections.singletonList(
                new CatalogItem("Dell", "Computer", "1001")
        );
    }

}
