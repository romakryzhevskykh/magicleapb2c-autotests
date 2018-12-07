package com.sarnova.helpers.models.categories;

public class CustomCategory extends Category {
    private String department;

    public CustomCategory(String id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
