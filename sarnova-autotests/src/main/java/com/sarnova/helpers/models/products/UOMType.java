package com.sarnova.helpers.models.products;

public enum UOMType {
    CS("Case"),
    BX,
    EA("Each");

    final String fullName;

    UOMType() {
        this.fullName = "";
    }

    UOMType(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean equalsByFullName(String fullName) {
        return this.fullName.equalsIgnoreCase(fullName);
    }
}
