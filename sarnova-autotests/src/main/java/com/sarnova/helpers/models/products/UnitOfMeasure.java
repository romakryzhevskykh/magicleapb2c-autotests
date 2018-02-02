package com.sarnova.helpers.models.products;

public class UnitOfMeasure {
    private final UOMType uomType;
    private final Double listPrice;
    private final Double yourPrice;

    public UnitOfMeasure(UOMType uomType, Double listPrice, Double yourPrice) {
        this.uomType = uomType;
        this.listPrice = listPrice;
        this.yourPrice = yourPrice;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public Double getYourPrice() {
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
