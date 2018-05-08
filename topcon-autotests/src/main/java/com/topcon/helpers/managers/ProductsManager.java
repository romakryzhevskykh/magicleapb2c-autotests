package com.topcon.helpers.managers;

import com.topcon.helpers.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductsManager {
    private ArrayList<Product> products = new ArrayList<>();

    public void createInstance(String id, String name, double price) {
        products.add(new Product(id, name, price));
    }

    public Product getAnyProduct() {
        return products.stream().findAny().orElseGet(() -> {throw new NullPointerException("No products in collection!");});
    }
}
