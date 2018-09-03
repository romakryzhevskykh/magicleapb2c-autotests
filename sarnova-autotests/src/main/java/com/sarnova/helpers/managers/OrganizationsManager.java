package com.sarnova.helpers.managers;

import com.sarnova.helpers.models.users.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationsManager {
    private final Organization organization;

    public OrganizationsManager() {
        this.organization = new Organization("E160280_ESHIP001");
    }

    public Organization getOrganization() {
        return organization;
    }
}
