package com.template.helpers.user_engine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserSessionFactory {

    private ThreadLocal<UserSession> tlUserSession = new ThreadLocal();
    private Map<UserSession, String> userToKeyMap = Collections.synchronizedMap(new HashMap());
    private Map<UserSession, Thread> userToThread = Collections.synchronizedMap(new HashMap());

    public synchronized UserSession getUserSession(User user) {
        String newKey = this.createKey(user);
        if(this.tlUserSession.get() == null) {
            this.createNewUserSession(user);
        } else {
            String key = this.userToKeyMap.get(this.tlUserSession.get());
            if(key == null) {
                this.createNewUserSession(user);
            } else if(!newKey.equals(key)) {
                this.createNewUserSession(user);
            }
        }
        return this.tlUserSession.get();
    }

    private synchronized void createNewUserSession(User user) {
        String newKey = this.createKey(user);
        UserSession userSession = this.newUserSession(user);
        this.userToKeyMap.put(userSession, newKey);
        this.userToThread.put(userSession, Thread.currentThread());
        this.tlUserSession.set(userSession);
    }

    private String createKey(User user) {
        return user.getUsername();
    }

    private UserSession newUserSession(User user) {
        return new UserSession(user);
    }
}
