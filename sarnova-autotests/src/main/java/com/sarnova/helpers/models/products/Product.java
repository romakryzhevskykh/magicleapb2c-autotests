package com.sarnova.helpers.models.products;

import java.util.ArrayList;

public abstract class Product {
    protected String sku;
    protected String name;
    protected ArrayList<ProductTestType> productTestTypes = new ArrayList<>();

    public Product(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public String getSku() {
        return sku;
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

    public abstract ArrayList<UnitOfMeasure> getUnitsOfMeasurement();
}
