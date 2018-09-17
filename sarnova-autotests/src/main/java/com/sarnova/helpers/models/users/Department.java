package com.sarnova.helpers.models.users;

public class Department {
    private final String id;

    public Department(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department: id - " + this.id;
    }

    public String getId() {
        return id;
    }
}
