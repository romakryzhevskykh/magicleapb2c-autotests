package com.template.storefront.models;

import com.template.helpers.UserCredentials;

public class User {
    private UserCredentials credentials;
    private boolean isLoggedIn = false;

    public User(UserCredentials userCredentials) {
        this.credentials = userCredentials;
    }

    public String getUsername() {
        return credentials.getLogin();
    }

    public String getPassword() {
        return credentials.getPassword();
    }

    public void setPassword(String password) {
        this.credentials.setPassword(password);
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
