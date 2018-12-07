package com.sarnova.helpers.user_engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserSessions {

    @Autowired private UsersManager usersManager;
    private List<UserSession> allSessionsList = new ArrayList<>();
    private InheritableThreadLocal<ArrayList<UserSession>> tlUserSession = new InheritableThreadLocal<>();

    private UserSessionFactory userFactory = new UserSessionFactory();

    public synchronized void setActiveUserSession(UserRole userRole) {
        User user;
        if (userRole.isTest()) {
            user = usersManager.getUsers().stream()
                    .filter(user1 -> user1.getUserRoles().contains(userRole))
                    .findAny()
                    .orElseGet(() -> {
                        throw new IllegalStateException("No such user role in properties: " + userRole.toString());
                    });
        } else {
            user = usersManager.getUsers().stream()
                    .filter(user1 -> user1.getUserRoles().stream().noneMatch(UserRole::isTest))
                    .filter(user1 -> user1.getUserRoles().contains(userRole))
                    .findAny()
                    .orElseGet(() -> {
                        throw new IllegalStateException("No such user role in properties: " + userRole.toString());
                    });
        }
        if (tlUserSession.get() == null) {
            tlUserSession.set(new ArrayList<>());
            tlUserSession.get().add(userFactory.getUserSession(user));
            allSessionsList.add(userFactory.getUserSession(user));
            userFactory.getUserSession(user).setActive(true);
        } else if (!userRole.isTest() && (!getActiveUserSession().getUserRoles().contains(userRole)
                || getActiveUserSession().getUserRoles().stream().anyMatch(UserRole::isTest))) {
            tlUserSession.get().forEach(user1 -> user1.setActive(false));
            tlUserSession.get().stream()
                    .filter(user1 -> user1.getUserRoles().stream().noneMatch(UserRole::isTest))
                    .filter(user1 -> user1.getUserRoles().contains(userRole))
                    .findFirst()
                    .orElseGet(() -> {
                        tlUserSession.get().add(userFactory.getUserSession(user));
                        allSessionsList.add(userFactory.getUserSession(user));
                        return userFactory.getUserSession(user);
                    }).setActive(true);
        } else if(userRole.isTest() && !getActiveUserSession().getUserRoles().contains(userRole)) {
            tlUserSession.get().forEach(user1 -> user1.setActive(false));
            tlUserSession.get().stream()
                    .filter(user1 -> user1.getUserRoles().contains(userRole))
                    .findFirst()
                    .orElseGet(() -> {
                        tlUserSession.get().add(userFactory.getUserSession(user));
                        allSessionsList.add(userFactory.getUserSession(user));
                        return userFactory.getUserSession(user);
                    }).setActive(true);
        }
    }

    public synchronized UserSession getActiveUserSession() {
        return tlUserSession.get().stream().filter(UserSession::isActive).findAny().orElse(null);
    }

    public UserSession getAnyUserSessionForUser(User user) {
        return allSessionsList.stream()
                .filter(userSession -> userSession.getUser().equals(user))
                .filter(UserSession::isLoggedIn)
                .findAny().orElse(null);
    }

    public UserSession getAnyUserSessionForOrganization(String department) {
        return allSessionsList.stream()
                .filter(userSession -> department.equals(userSession.getUser().getDepartment()))
                .filter(UserSession::isLoggedIn)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("There is no user session for department " + department));
    }
}
