package com.sarnova.helpers.models;

import com.sarnova.helpers.managers.ProductsManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class IndividualProduct extends Product {
    @Autowired private ProductsManager productsManager;

    private boolean isGroupMember = false;
    private double price;
    private int stockLevel;

    public IndividualProduct(String sku) {
        this.sku = sku;
    }

    @PostConstruct
    private void addToProductsList() {
        productsManager.addTestProduct(this);
    }

    public void setGroupMember(boolean isGroupMember) {
        this.isGroupMember = isGroupMember;
    }

    public boolean isGroupMember() {
        return isGroupMember;
    }
}
