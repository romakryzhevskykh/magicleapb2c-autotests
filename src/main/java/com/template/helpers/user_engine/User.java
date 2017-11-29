package com.template.helpers.user_engine;

public class User {
    private UserCredentials credentials;
    private boolean isLoggedIn = false;
    private boolean isActive = false;

    public User(UserCredentials userCredentials) {
        this.credentials = userCredentials;
    }

    public UserRole getUserRole() {
        return credentials.getUserRole();
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

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }
}
