package com.template.helpers;

import com.template.storefront.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersPool {

    @Autowired UserCredentials basicUserCredentials;

    private UserFactory storefrontUserFactory = new UserFactory();

    public User getUser() {
        return storefrontUserFactory.getUser(basicUserCredentials);
    }

}
