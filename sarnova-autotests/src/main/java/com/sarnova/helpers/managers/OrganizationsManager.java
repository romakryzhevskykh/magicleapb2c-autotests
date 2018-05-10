package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.users.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationsManager {
    private final Organization organization;

    public OrganizationsManager() {
        this.organization = new Organization("112395_SHIP001");
    }

    public Organization getOrganization() {
        return organization;
    }
}
