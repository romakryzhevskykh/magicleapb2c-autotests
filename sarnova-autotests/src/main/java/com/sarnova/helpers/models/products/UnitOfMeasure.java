package com.sarnova.helpers.models.products;

public class UnitOfMeasure {
    private final UOMType uomType;
    private final double listPrice;
    private final double yourPrice;

    public UnitOfMeasure(UOMType uomType, double listPrice, double yourPrice) {
        this.uomType = uomType;
        this.listPrice = listPrice;
        this.yourPrice = yourPrice;
    }

    public double getListPrice() {
        return listPrice;
    }

    public double getYourPrice() {
        return yourPrice;
    }

    public UOMType getUomType() {
        return uomType;
    }

    @Override
    public String toString() {
        return uomType.toString();
    }
}
