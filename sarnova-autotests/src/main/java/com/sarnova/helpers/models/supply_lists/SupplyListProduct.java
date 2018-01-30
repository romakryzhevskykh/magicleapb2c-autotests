package com.sarnova.helpers.models.supply_lists;

import com.sarnova.helpers.models.products.IndividualProduct;

public class SupplyListProduct{
    private final IndividualProduct individualProduct;
    private boolean isActive;

    public SupplyListProduct(IndividualProduct individualProduct) {
        this.individualProduct = individualProduct;
    }
}
