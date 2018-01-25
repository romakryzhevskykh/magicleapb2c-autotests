package com.sarnova.helpers.models;

import com.sarnova.helpers.managers.ProductsManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class GroupProduct extends Product {
    @Autowired private ProductsManager productsManager;

    private ArrayList<IndividualProduct> individualProducts = new ArrayList<>();

    public GroupProduct(String sku, ArrayList<IndividualProduct> individualProducts) {
        this.sku = sku;
        individualProducts.forEach(individualProduct -> individualProduct.setGroupMember(true));
        this.individualProducts.addAll(individualProducts);
        productsManager.addTestProduct(this);
    }
}
