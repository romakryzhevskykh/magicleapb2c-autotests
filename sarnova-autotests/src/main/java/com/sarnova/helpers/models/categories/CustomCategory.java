package com.sarnova.helpers.models.categories;

import com.sarnova.helpers.models.users.Department;

public class CustomCategory extends Category {
    private final Department organization;

    public CustomCategory(String id, String name, Department organization) {
        super(id, name);
        this.organization = organization;
    }

    public Department getOrganization() {
        return organization;
    }
}
