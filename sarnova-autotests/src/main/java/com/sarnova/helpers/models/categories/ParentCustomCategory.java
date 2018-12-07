package com.sarnova.helpers.models.categories;

import java.util.HashSet;
import java.util.Set;

public class ParentCustomCategory extends CustomCategory {
    private Set<ChildCustomCategory> childCustomCategories = new HashSet<>();

    public ParentCustomCategory(String id, String name, String department) {
        super(id, name, department);
    }

    public Set<ChildCustomCategory> getChildCustomCategories() {
        return childCustomCategories;
    }

    @Override
    public String toString() {
        return "Parent CC: name - " + this.getName() + ", id: " + this.getId();
    }
}
