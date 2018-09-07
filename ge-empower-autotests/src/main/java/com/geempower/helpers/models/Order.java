package com.geempower.helpers.models;

import lombok.Getter;

import java.util.HashMap;

public class Order {
    @Getter
    final long orderId;
    @Getter
    double finalOrderPrice;
    @Getter
    HashMap<Product, Integer> products = new HashMap<>();
    @Getter
    String catalogNo;
    @Getter
    int quantity;
    @Getter
    double totalNetPrice;

    public Order(long orderId, HashMap<Product, Integer> products) {
        this.orderId = orderId;
        this.products.putAll(products);
        this.finalOrderPrice = products.keySet().stream()
                .mapToDouble(product -> Double.parseDouble(product.getFinalNetPrice()) * products.get(product))
                .sum();
    }

    public Order(long orderId, String catalogNo, int quantity) {
        this.orderId = orderId;
        this.catalogNo = catalogNo;
        this.quantity = quantity;
    }

    public Order(long orderId, double totalNetPrice) {
        this.orderId = orderId;
        this.totalNetPrice = totalNetPrice;
    }
}