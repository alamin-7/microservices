package com.microservice.shop_catalog_service.models;

public class ProductQualityRating {

    private String productID;
    private int rating;

    public ProductQualityRating(){

    }

    public ProductQualityRating(String productID, int rating) {
        this.productID = productID;
        this.rating = rating;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
