package com.geempower.helpers.models;

import lombok.Getter;
import lombok.Setter;

public class Product {
    @Getter @Setter String id;
    @Getter @Setter String catalogueNo;
    @Getter @Setter String description;
    @Getter @Setter String listPrice;
    @Getter @Setter String finalNetPrice;
    @Getter @Setter String availability;
    @Getter @Setter Region region;

    public Product(String catalogueNo, Region region, String id){
        this.catalogueNo = catalogueNo;
        this.region = region;
        this.id = id;
    }
}