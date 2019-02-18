package com.template.helpers.models.products;


import lombok.Setter;

public class ProductAttribute {

    @Setter private String name;
    @Setter private Object value;

    public ProductAttribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getStringValue() {
        return String.valueOf(this.value);
    }

    public boolean getBooleanValue() {
        return Boolean.valueOf(this.value.toString());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Attribute: " +
                "name='" + name + '\'' +
                ", value=" + value;
    }
}
