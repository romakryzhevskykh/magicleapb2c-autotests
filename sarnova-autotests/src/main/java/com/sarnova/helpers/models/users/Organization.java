package com.sarnova.helpers.models.users;

public class Organization {
    private final String id;

    public Organization(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Organization: id - " + this.id;
    }

    public String getId() {
        return id;
    }
}
