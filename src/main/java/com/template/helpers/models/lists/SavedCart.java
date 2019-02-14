package com.template.helpers.models.lists;

import com.template.helpers.models.products.VariantProduct;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class SavedCart {

    @Getter @Setter private String name;
    @Getter private Map<VariantProduct, Integer> products = new HashMap<>();

    public SavedCart(String name) {
        this.name = name;
    }

    public void addProduct(VariantProduct product, int quantity) {
        this.products.put(product, quantity);
    }

    public void addProducts(Map<VariantProduct, Integer> products) {
        this.products.putAll(products);
    }

    @Override
    public String toString() {
        return "List: " +
                "name='" + name + '\'';
    }
}
