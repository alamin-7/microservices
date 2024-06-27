package com.microservice.shop_catalog_service.models;

public class CatalogItem {

    private String productName;
    private String productDescription;
    private String productID;

    public CatalogItem(String productName, String productDescription, String productID) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductID() {
        return productID;
    }
}
