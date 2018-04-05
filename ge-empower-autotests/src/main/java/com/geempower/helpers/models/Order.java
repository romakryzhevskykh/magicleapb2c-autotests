package com.geempower.helpers.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class Order {
    @Getter @Setter Long orderId;
    @Getter @Setter Double finalOrderPrice;
    @Getter @Setter HashMap<Product, Integer> product;

    public Order(long orderId, double finalOrderPrice){
        this.orderId = orderId;
        this.finalOrderPrice = finalOrderPrice;
    }
}
