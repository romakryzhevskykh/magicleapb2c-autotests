package com.sarnova.helpers.models.supply_lists;

import com.sarnova.helpers.user_engine.User;

import java.util.ArrayList;
import java.util.List;

public class SupplyList {
    private boolean isActive;
    private List<SupplyListProduct> supplyProductsInList;
    private final User user;
    private String name;
    private final String id;

    public SupplyList(User user, String name, String id, List<SupplyListProduct> supplyIndividualProducts) {
        this.user = user;
        this.name = name;
        this.id = id;
        this.isActive = true;
        this.supplyProductsInList = supplyIndividualProducts;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setSupplyProductsList(ArrayList<SupplyListProduct> supplyIndividualProductsInList) {
        this.supplyProductsInList = supplyIndividualProductsInList;
    }

    public void addSupplyProductToList(SupplyListProduct supplyIndividualProduct) {
        this.supplyProductsInList.add(supplyIndividualProduct);
    }

    public void addSupplyProductsToList(ArrayList<SupplyListProduct> supplyIndividualProducts) {
        this.supplyProductsInList.addAll(supplyIndividualProducts);
    }

    public List<SupplyListProduct> getSupplyProductsInList() {
        return supplyProductsInList;
    }

    public String getId() {
        return id;
    }
}
