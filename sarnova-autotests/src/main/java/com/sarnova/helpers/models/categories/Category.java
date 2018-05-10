package com.sarnova.helpers.models.categories;

public class Category {
    private final String name;
    private final String id;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
