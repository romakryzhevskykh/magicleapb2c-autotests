package com.sarnova.helpers.models.categories;

import com.sarnova.helpers.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ChildCustomCategory extends CustomCategory {
    private final ParentCustomCategory parentCustomCategory;
    private List<Product> products = new ArrayList<>();

    public ChildCustomCategory(String id, String name, ParentCustomCategory parentCustomCategory) {
        super(id, name, parentCustomCategory.getDepartment());
        this.parentCustomCategory = parentCustomCategory;
        parentCustomCategory.getChildCustomCategories().add(this);
    }

    public ParentCustomCategory getParentCustomCategory() {
        return parentCustomCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Child CC: name - " + this.getName() + ", id: " + this.getId();
    }
}
