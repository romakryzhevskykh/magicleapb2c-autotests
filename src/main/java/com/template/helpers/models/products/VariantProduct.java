package com.template.helpers.models.products;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class VariantProduct {

    @Getter private final BaseProduct baseProduct;
    @Getter private final String id;
    @Getter private double price;
    @Getter protected Set<ProductTestType> productTestTypes = new HashSet<>();
    @Getter private Set<ProductAttribute> productAttributes = new HashSet<>();

    public VariantProduct(BaseProduct baseProduct, String id, double price) {
        this.baseProduct = baseProduct;
        this.id = id;
        this.price = price;
    }

    public VariantProduct(BaseProduct baseProduct, String id, double price, Set<ProductAttribute> productAttributes) {
        this.baseProduct = baseProduct;
        this.id = id;
        this.price = price;
        this.productAttributes = productAttributes;
    }

    public void addProductTestType(ProductTestType productTestType) {
        productTestTypes.add(productTestType);
    }

    public void addProductAttribute(ProductAttribute productAttribute) {
        this.productAttributes.add(productAttribute);
    }

    @Override
    public String toString() {
        return "VariantProduct:" +
                "baseProduct=" + baseProduct +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", productTestTypes=" + productTestTypes +
                ", productAttributes=" + productAttributes;
    }
}
