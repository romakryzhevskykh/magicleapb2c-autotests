package com.sarnova.helpers.models.categories;

import com.sarnova.helpers.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ChildCustomCategory extends CustomCategory {

    private String parentCategoryId;
    private List<Product> products = new ArrayList<>();

    public ChildCustomCategory(String id, String name, String parentCategoryId) {
        super(id, name);
        this.parentCategoryId = parentCategoryId;
    }

    public String getParentCustomCategory() {
        return parentCategoryId;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Child CC: name - " + this.getName() + ", id: " + this.getId();
    }
}
