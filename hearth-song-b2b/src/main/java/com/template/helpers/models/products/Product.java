package com.template.helpers.models.products;

import java.util.ArrayList;

public class Product {
    protected String sku;
    protected String name;
    protected boolean isLicenseRestricted;
    protected ArrayList<ProductTestType> productTestTypes = new ArrayList<>();

    public Product(String sku, String name, String isLicenseRestricted) {
        this.sku = sku;
        this.name = name;
        this.isLicenseRestricted = Boolean.valueOf(isLicenseRestricted);
    }

    public String getSku() {
        return sku;
    }

    public boolean isLicenseRestricted() {
        return isLicenseRestricted;
    }

    public void addProductTestType(ProductTestType productTestType) {
        this.productTestTypes.add(productTestType);
    }

    public ArrayList<ProductTestType> getProductTestTypes() {
        return productTestTypes;
    }

    @Override
    public String toString() {
        return "SKU: " + this.sku + ", name: " + this.name + ", product class: " + this.getClass();
    }
}