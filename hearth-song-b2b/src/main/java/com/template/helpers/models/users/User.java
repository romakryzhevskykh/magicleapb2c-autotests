package com.template.helpers.models.users;

import com.template.hybris.Cockpit;

import java.util.ArrayList;

public class User {

    private UserTitle userTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private ArrayList<UserRole> userRoles = new ArrayList<>();
    private Cockpit userCockpit;
    private boolean isEnabled;

    public User(String username, String password, Cockpit userCockpit) {
        this.username = username;
        this.password = password;
        this.userCockpit = userCockpit;
        this.isEnabled = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<UserRole> getUserRoles() {
        return userRoles;
    }

    public Cockpit getUserCockpit() {
        return userCockpit;
    }

    @Override
    public String toString() {
        return "User: " + this.username + ", Cockpit: " + this.userCockpit.getBaseUrl() + ", Roles: " + this.getUserRoles();
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserTitle getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(UserTitle userTitle) {
        this.userTitle = userTitle;
    }
}
