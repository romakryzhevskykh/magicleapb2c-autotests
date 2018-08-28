package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.users.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationsManager {
    private final Organization organization;

    public OrganizationsManager() {
        this.organization = new Organization("E15019000_ESHIP000");
    }

    public Organization getOrganization() {
        return organization;
    }
}
