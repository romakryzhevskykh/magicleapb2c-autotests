package com.sarnova.helpers.models.supply_lists;

import com.sarnova.helpers.user_engine.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SupplyList {
    private boolean isActive;
    private boolean isFavorite;
    private List<SupplyListProduct> supplyProductsInList;
    private final User user;
    private ArrayList<User> sharedWithUsers = new ArrayList<>();
    private String name;
    private final String id;

    public SupplyList(User user, String name, String id, List<SupplyListProduct> supplyIndividualProducts) {
        this.user = user;
        this.name = name;
        this.id = id;
        this.isActive = true;
        this.isFavorite = false;
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

    public void setSupplyProductsList(List<SupplyListProduct> supplyIndividualProductsInList) {
        this.supplyProductsInList = supplyIndividualProductsInList;
    }

    public void addSupplyProductToList(SupplyListProduct supplyIndividualProduct) {
        this.supplyProductsInList.add(supplyIndividualProduct);
    }

    public void addSupplyProductsToList(List<SupplyListProduct> supplyIndividualProducts) {
        List<String> newProductsSkus = supplyIndividualProducts.stream().map(SupplyListProduct::getSku).collect(Collectors.toList());
        this.supplyProductsInList.removeAll(this.supplyProductsInList
                .stream()
                .filter(supplyListProduct -> newProductsSkus.contains(supplyListProduct.getSku()))
                .collect(Collectors.toList()));
        this.supplyProductsInList.addAll(supplyIndividualProducts);
    }

    public List<SupplyListProduct> getSupplyProductsInList() {
        return supplyProductsInList;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name + ", status: " + this.isActive + ", products: " + this.supplyProductsInList;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
