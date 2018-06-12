package com.sarnova.helpers.models.saved_carts;

import com.sarnova.helpers.models.products.UnitOfMeasure;
import com.sarnova.helpers.user_engine.User;

import java.util.HashMap;
import java.util.Map;

public class SavedCart {
    private final String id;
    private final User user;
    private String name;
    private String description;
    private Map<UnitOfMeasure, Integer> unitOfMeasures = new HashMap<>();

    public SavedCart(String id, User user, String name) {
        this.id = id;
        this.user = user;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<UnitOfMeasure, Integer> getUnitOfMeasures() {
        return unitOfMeasures;
    }
}
