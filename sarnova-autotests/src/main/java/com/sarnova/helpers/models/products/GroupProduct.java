package com.sarnova.helpers.models.products;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GroupProduct extends Product {

    private ArrayList<IndividualProduct> individualProducts = new ArrayList<>();

    public GroupProduct(String sku, String name, ArrayList<IndividualProduct> individualProducts) {
        super(sku, name);
        individualProducts.forEach(individualProduct -> individualProduct.setGroupMember(true));
        this.individualProducts.addAll(individualProducts);
    }

    public ArrayList<IndividualProduct> getIndividualProducts() {
        return individualProducts;
    }


    @Override
    public ArrayList<UnitOfMeasure> getUnitsOfMeasurement() {
        return getIndividualProducts()
                .stream()
                .flatMap(individualProduct -> individualProduct.getUnitsOfMeasurement().stream())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
