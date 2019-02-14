package com.template.helpers.models.products;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

public class BaseProduct {

    @Getter private final String id;
    @Getter private final String name;
    @Getter private Set<VariantProduct> variantProducts = new HashSet<>();
    @Getter private Set<ProductAttribute> productAttributes = new HashSet<>();

    public BaseProduct(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public BaseProduct(String id, String name, Set<ProductAttribute> productAttributes) {
        this.id = id;
        this.name = name;
        this.productAttributes = productAttributes;
    }

    public void addProductAttribute(ProductAttribute productAttribute) {
        this.productAttributes.add(productAttribute);
    }
}
