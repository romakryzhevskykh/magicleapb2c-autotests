package com.sarnova.helpers.models.users;

import com.sarnova.helpers.user_engine.Permission;

import java.util.ArrayList;

public class UserGroup {
    private String name;
    private String uid;
    private boolean isInitiated = false;
    private ArrayList<Permission> permissions = new ArrayList<>();

    public UserGroup(String uid) {
        this.uid = uid;
    }

    public UserGroup(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUId() {
        return uid;
    }

    public ArrayList<Permission> getPermissions() {
        return permissions;
    }

    @Override
    public String toString() {
        return "User group uid: " + this.uid + ", permissions: " + permissions;
    }

    public boolean isInitiated() {
        return isInitiated;
    }

    public void setInitiated(boolean initiated) {
        isInitiated = initiated;
    }
}
