package com.geempower.helpers.models;

import lombok.Getter;

import java.util.ArrayList;
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
    @Getter
    ArrayList<Product> allProducts = new ArrayList<>();
    @Getter
    HashMap<String, String> shippingNotes = new HashMap<>();


    public Order(long orderId, HashMap<Product, Integer> products) {
        this.orderId = orderId;
        this.products.putAll(products);
        this.finalOrderPrice = products.keySet().stream()
                .mapToDouble(product -> Double.parseDouble(product.getFinalNetPrice()) * products.get(product))
                .sum();
    }

    public Order(long orderId, HashMap<Product, Integer> products, HashMap<String, String> shippingNotes) {
        this.orderId = orderId;
        this.products.putAll(products);
        this.finalOrderPrice = products.keySet().stream()
                .mapToDouble(product -> Double.parseDouble(product.getFinalNetPrice()) * products.get(product))
                .sum();
        this.shippingNotes.putAll(shippingNotes);
    }

    public Order(long orderId, String catalogNo, int quantity) {
        this.orderId = orderId;
        this.catalogNo = catalogNo;
        this.quantity = quantity;
    }

    public Order(long orderId, double totalNetPrice, ArrayList<Product> allProducts) {
        this.orderId = orderId;
        this.totalNetPrice = totalNetPrice;
        this.allProducts.addAll(allProducts);
    }
}