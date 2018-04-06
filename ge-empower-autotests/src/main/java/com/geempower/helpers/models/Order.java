package com.geempower.helpers.models;

import lombok.Getter;

import java.util.HashMap;

public class Order {
    @Getter final long orderId;
    @Getter final double finalOrderPrice;
    @Getter HashMap<Product, Integer> products = new HashMap<>();

    public Order(long orderId, HashMap<Product, Integer> products){
        this.orderId = orderId;
        this.products.putAll(products);
        this.finalOrderPrice = products.keySet().stream()
                .mapToDouble(product -> Double.parseDouble(product.getFinalNetPrice()) * products.get(product))
                .sum();

    }
}
