package com.sarnova.emp.service.hac.impl;

import com.sarnova.emp.service.hac.AuthorizationService;
import com.sarnova.emp.webservice.hac.AuthorizationWebserviceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultAuthorizationService implements AuthorizationService {

    private final AuthorizationWebserviceClient authorizationWebserviceClient;

    @Autowired
    public DefaultAuthorizationService(AuthorizationWebserviceClient authorizationWebserviceClient) {
        this.authorizationWebserviceClient = authorizationWebserviceClient;
    }

    @Override
    public void login(String user, String password) {
        authorizationWebserviceClient.login(user, password);
    }
}
