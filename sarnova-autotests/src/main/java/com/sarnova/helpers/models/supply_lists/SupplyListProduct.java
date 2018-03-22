package com.sarnova.helpers.models.supply_lists;

import com.sarnova.helpers.models.products.IndividualProduct;

public class SupplyListProduct {
    private final IndividualProduct individualProduct;
    private boolean isActive;

    public SupplyListProduct(IndividualProduct individualProduct) {
        this.individualProduct = individualProduct;
        this.isActive = true;
    }

    public SupplyListProduct(IndividualProduct individualProduct, boolean isActive) {
        this.individualProduct = individualProduct;
        this.isActive = isActive;
    }

    public String  getSku() {
        return individualProduct.getSku();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public IndividualProduct getIndividualProduct() {
        return individualProduct;
    }

    @Override
    public String toString() {
        return this.individualProduct.toString() + ", active status: " + this.isActive;
    }
}
