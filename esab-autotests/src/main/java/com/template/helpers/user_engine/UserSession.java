package com.template.helpers.user_engine;

public class UserSession {
    private User user;
    private boolean isLoggedIn = false;
    private boolean isActive = false;

    public UserSession(User user) {
        this.user = user;
    }

    public UserRole getUserRole() {
        return user.getUserRole();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public User getUser() {
        return user;
    }

    public void setPassword(String password) {
        this.user.setPassword(password);
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
    
    public String getName(){
    	return user.getName();
    }
}
