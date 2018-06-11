package com.sarnova.helpers.user_engine;

import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSession {
    private User user;
    private boolean isLoggedIn = false;
    private boolean isActive = false;
    private List<String> cookies = new ArrayList<>();

    public UserSession(User user) {
        this.user = user;
    }

    public Set<UserRole> getUserRoles() {
        return user.getUserRoles();
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

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

    public void setCookies(Set<Cookie> cookies) {
        this.cookies.clear();
        this.cookies.addAll(cookies.stream().map(Cookie::toString).collect(Collectors.toList()));
    }

    public List<String> getCookies() {
        return cookies;
    }
}
