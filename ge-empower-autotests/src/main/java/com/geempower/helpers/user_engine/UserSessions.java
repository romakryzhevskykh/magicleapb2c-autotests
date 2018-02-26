package com.geempower.helpers.user_engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserSessions {

    @Autowired private ArrayList<User> usersList;
    private InheritableThreadLocal<ArrayList<UserSession>> tlUserSession = new InheritableThreadLocal<>();

    private UserSessionFactory userFactory = new UserSessionFactory();

    public synchronized void setActiveUserSession(UserRole userRole) {
        User user = usersList.stream().filter(user1 -> user1.getUserRole().equals(userRole))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("No such user role in properties: " + userRole.toString());
                });
        if (tlUserSession.get() == null) {
            tlUserSession.set(new ArrayList<>());
            tlUserSession.get().add(userFactory.getUserSession(user));
            userFactory.getUserSession(user).setActive(true);
        } else if (!getActiveUserSession().getUserRole().equals(userRole)) {
            tlUserSession.get().forEach(user1 -> user1.setActive(false));
            tlUserSession.get().stream().filter(user1 -> user1.getUserRole().equals(userRole)).findFirst()
                    .orElseGet(() -> {
                        tlUserSession.get().add(userFactory.getUserSession(user));
                        return userFactory.getUserSession(user);
                    }).setActive(true);
        }
    }

    public synchronized UserSession getActiveUserSession() {
        return tlUserSession.get().stream().filter(UserSession::isActive).findAny().orElse(null);
    }

    public ArrayList<User> getUsersList() {
        /*
        Workaround.
        Temporary method.
        TODO: create UsersManager, instantiate users via manager and Spring xml
         */
        return usersList;
    }
}
