package com.geempower.helpers.models;

import lombok.Getter;
import lombok.Setter;

public class Product {
    @Getter @Setter String id;
    @Getter @Setter String catalogNo;
    @Getter @Setter String description;
    @Getter @Setter String listPrice;
    @Getter @Setter String finalNetPrice;
    @Getter @Setter String availability;
    @Getter @Setter Region region;

    public Product(String catalogNo, Region region, String id){
        this.catalogNo = catalogNo;
        this.region = region;
        this.id = id;
    }

    public Product(String catalogNo, String description){
        this.catalogNo = catalogNo;
        this.description = description;
    }
}