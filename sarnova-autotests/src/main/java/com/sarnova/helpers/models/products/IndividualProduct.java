package com.sarnova.helpers.models.products;

import java.util.ArrayList;

public class IndividualProduct extends Product {

    private boolean isGroupMember = false;
    private boolean isDiscontinued = false;
    private ArrayList<IndividualProduct> accessoriesProducts;
    private ArrayList<IndividualProduct> alternativeProducts;
    private final ArrayList<UnitOfMeasure> unitsOfMeasurement;

    public IndividualProduct(String sku, String name, ArrayList<UnitOfMeasure> unitsOfMeasurement,
                             ArrayList<IndividualProduct> accessoriesProducts, ArrayList<IndividualProduct> alternativeProducts) {
        super(sku, name);
        this.unitsOfMeasurement = unitsOfMeasurement;
        this.accessoriesProducts = accessoriesProducts;
        this.alternativeProducts = alternativeProducts;
    }

    public void setGroupMember(boolean isGroupMember) {
        this.isGroupMember = isGroupMember;
    }

    public boolean isGroupMember() {
        return isGroupMember;
    }

    public double getListPriceByUOM(UOMType uomType) {
        return unitsOfMeasurement.stream()
                .filter(unitOfMeasure -> unitOfMeasure.getUomType().equals(uomType))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("Product: " + this + " has no " + uomType + " type of UOM.");
                }).getListPrice();
    }

    public double getYourPriceByUOM(UOMType uomType) {
        return unitsOfMeasurement.stream()
                .filter(unitOfMeasure -> unitOfMeasure.getUomType().equals(uomType))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("Product: " + this + " has no " + uomType + " type of UOM.");
                }).getYourPrice();
    }

    public ArrayList<Double> getListPrices() {
        return unitsOfMeasurement.stream()
                .map(UnitOfMeasure::getListPrice)
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public ArrayList<Double> getYourPrices() {
        return unitsOfMeasurement.stream()
                .map(UnitOfMeasure::getYourPrice)
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public ArrayList<UnitOfMeasure> getUnitsOfMeasurement() {
        return unitsOfMeasurement;
    }

    public boolean isDiscontinued() {
        return isDiscontinued;
    }

    public ArrayList<IndividualProduct> getAccessoriesProducts() {
        return accessoriesProducts != null ?  accessoriesProducts : new ArrayList<>();
    }

    public ArrayList<IndividualProduct> getAlternativeProducts() {
        return alternativeProducts != null ?  alternativeProducts : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Product name: " + this.name + ", SKU: " + this.sku;
    }
}
