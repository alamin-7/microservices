package com.microservice.shop_catalog_service.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogItem that = (CatalogItem) o;
        return Objects.equals(productName, that.productName) && Objects.equals(productDescription, that.productDescription) && Objects.equals(productID, that.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productDescription, productID);
    }
}
