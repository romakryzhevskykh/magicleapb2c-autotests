package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductsManager {
    private ArrayList<Product> testProducts = new ArrayList<>();

    public ArrayList<Product> getTestProducts() {
        return testProducts;
    }

    public void addTestProduct(Product product) {
        testProducts.add(product);
    }
}
