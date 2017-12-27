package com.template.helpers.user_engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UsersPool {

    @Autowired ArrayList<UserCredentials> userCredentialsList;
    private InheritableThreadLocal<ArrayList<User>> tlUsersList = new InheritableThreadLocal<>();

    private UserFactory userFactory = new UserFactory();

    public synchronized void setActiveUser(UserRole userRole) {
        UserCredentials userCredentials = userCredentialsList.stream().filter(userCredentials1 -> userCredentials1.getUserRole().equals(userRole))
                .findAny()
                .orElseGet(() -> {
                    throw new NullPointerException("No such user role in properties: " + userRole.toString());
                });
        if (tlUsersList.get() == null) {
            tlUsersList.set(new ArrayList<>());
            tlUsersList.get().add(userFactory.getUser(userCredentials));
            userFactory.getUser(userCredentials).setActive(true);
        } else if (!getActiveUser().getUserRole().equals(userRole)) {
            tlUsersList.get().forEach(user -> user.setActive(false));
            tlUsersList.get().stream().filter(user -> user.getUserRole().equals(userRole)).findFirst()
                    .orElseGet(() -> {
                        tlUsersList.get().add(userFactory.getUser(userCredentials));
                        return userFactory.getUser(userCredentials);
                    }).setActive(true);
        }
    }

    public synchronized User getActiveUser() {
        return tlUsersList.get().stream().filter(User::isActive).findAny().orElse(null);
    }
}
