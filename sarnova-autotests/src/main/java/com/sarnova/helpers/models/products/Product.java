package com.sarnova.helpers.models.products;

public abstract class Product {
    protected String sku;
    protected String name;
    protected ProductTestType productTestType;

    public Product(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setProductTestType(ProductTestType productTestType) {
        this.productTestType = productTestType;
    }

    public ProductTestType getProductTestType() {
        return productTestType;
    }
}
