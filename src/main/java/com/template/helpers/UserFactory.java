package com.template.helpers;

import com.template.storefront.models.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserFactory {

    private ThreadLocal<User> tlUser = new ThreadLocal();
    private Map<User, String> userToKeyMap = Collections.synchronizedMap(new HashMap());
    private Map<User, Thread> userToThread = Collections.synchronizedMap(new HashMap());

    public synchronized User getUser(UserCredentials userCredentials) {
        String newKey = this.createKey(userCredentials);
        if(this.tlUser.get() == null) {
            this.createNewUser(userCredentials);
        } else {
            String key = this.userToKeyMap.get(this.tlUser.get());
            if(key == null) {
                this.createNewUser(userCredentials);
            } else if(!newKey.equals(key)) {
                this.createNewUser(userCredentials);
            }
        }

        return this.tlUser.get();
    }

    private synchronized void createNewUser(UserCredentials userCredentials) {
        String newKey = this.createKey(userCredentials);
        User user = this.newUser(userCredentials);
        this.userToKeyMap.put(user, newKey);
        this.userToThread.put(user, Thread.currentThread());
        this.tlUser.set(user);
    }

    private String createKey(UserCredentials userCredentials) {
        return userCredentials.getLogin();
    }

    private User newUser(UserCredentials userCredentials) {
        return new User(userCredentials);
    }
}
