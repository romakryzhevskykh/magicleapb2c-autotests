package com.sarnova.helpers.models.categories;

import com.sarnova.helpers.models.users.Department;

import java.util.HashSet;

public class ParentCustomCategory extends CustomCategory {
    private HashSet<ChildCustomCategory> childCustomCategories = new HashSet<>();

    public ParentCustomCategory(String id, String name, Department organization) {
        super(id, name, organization);
    }

    public HashSet<ChildCustomCategory> getChildCustomCategories() {
        return childCustomCategories;
    }

    @Override
    public String toString() {
        return "Parent CC: name - " + this.getName() + ", id: " + this.getId();
    }
}
