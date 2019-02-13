package com.template.helpers.user_engine;

import com.template.helpers.models.users.User;
import com.template.helpers.models.users.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSession {
    @Getter private User user;
    @Getter private boolean isLoggedIn = false;
    @Getter @Setter private boolean isActive = false;
    @Getter private List<String> cookies;

    public UserSession(User user) {
        this.user = user;
    }

    public ArrayList<UserRole> getUserRoles() {
        return user.getUserRoles();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public void setPassword(String password) {
        this.user.setPassword(password);
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void setCookies(List<String> cookies) {
        this.cookies = cookies;
    }

    public void addCookies(List<String> cookies) {
        List<String> addCookies = cookies.stream()
                .filter(cookie1 -> this.cookies.stream().noneMatch(cookie2 -> cookie1.startsWith(cookie2.split(";")[0])))
                .collect(Collectors.toList());

        System.out.println("ADD Cookies: " + (addCookies.isEmpty() ? "All Cookies are already present." : addCookies));
        if (!addCookies.isEmpty())
            this.cookies.addAll(addCookies);
    }

    public void setCookies(Set<Cookie> cookies) {
        if (this.cookies == null) {
            setCookies(cookies.stream().map(Cookie::toString).collect(Collectors.toList()));
        } else
            addCookies(cookies.stream().map(Cookie::toString).collect(Collectors.toList()));
    }

    public void clearCookies() {
        this.cookies = null;
    }
}
