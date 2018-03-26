package com.geempower.helpers.models;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

public class Order {
    @Getter @Setter Integer extendPrice;
    @Getter @Setter HashMap<Product, Integer> product;
}
