package com.sarnova.helpers.user_engine;

import com.sarnova.helpers.models.users.UserGroup;
import com.sarnova.hybris.Cockpit;

import java.util.HashSet;
import java.util.Set;

public class User {

    private boolean isInitialized = false;
    private UserTitle userTitle;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Set<UserRole> userRoles = new HashSet<>();
    private Cockpit userCockpit;
    private Set<UserGroup> userGroups = new HashSet<>();
    private String department;
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

    public Set<UserRole> getUserRoles() {
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

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }
}
