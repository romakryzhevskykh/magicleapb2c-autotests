package com.sarnova.helpers.models.categories;

import com.sarnova.helpers.models.users.Organization;

public class CustomCategory extends Category {
    private final Organization organization;

    public CustomCategory(String id, String name, Organization organization) {
        super(id, name);
        this.organization = organization;
    }

    public Organization getOrganization() {
        return organization;
    }
}
