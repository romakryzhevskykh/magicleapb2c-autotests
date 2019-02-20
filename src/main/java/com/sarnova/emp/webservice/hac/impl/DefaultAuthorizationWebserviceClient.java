package com.sarnova.emp.webservice.hac.impl;

import com.google.common.collect.Iterables;
import com.sarnova.emp.util.RegexUtils;
import com.sarnova.emp.webservice.hac.AuthorizationWebserviceClient;
import com.sarnova.emp.framework.rest.client.RestTemplateHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Component
public class DefaultAuthorizationWebserviceClient extends AbstractWebserviceClient implements AuthorizationWebserviceClient {

    private static final String ALL_EXCEPT_JSESSION_ID_PATTERN = ";(.*)$";
    private static final String USER = "j_username";
    private static final String PASSWORD = "j_password";
    private static final String CRF = "_csrf";
    private static final String COOKIE = "Set-Cookie";

    private final RestTemplateHolder restTemplateHolder;

    @Autowired
    public DefaultAuthorizationWebserviceClient(RestTemplateHolder restTemplateHolder) {
        this.restTemplateHolder = restTemplateHolder;
    }

    @Override
    public void login(String user, String password) {
        String body = openLoginPage();
        String crf = getCrfCode(body);
        restTemplateHolder.setCrfToken(crf);
        ResponseEntity<String> loginResponse = securityCheckLogin(user, password, crf);
        String jsessionid = getJSessionId(loginResponse);
        restTemplateHolder.setJSessionId(jsessionid);
    }

    private String openLoginPage() {
        ResponseEntity<String> response = getRestTemplate().getForEntity(getHacUrl() + "login.jsp", String.class);
        return response.getBody();
    }

    private ResponseEntity<String> securityCheckLogin(String user, String password, String crf) {
        return getRestTemplate().postForEntity(getHacUrl() + "j_spring_security_check",
                setParamsToUrl(user, password, crf), String.class);
    }

    private MultiValueMap<String, String> setParamsToUrl(String user, String password, String crf) {
        MultiValueMap<String, String> urlParameters = new LinkedMultiValueMap<>();
        urlParameters.add(USER, user);
        urlParameters.add(PASSWORD, password);
        urlParameters.add(CRF, crf);
        return urlParameters;
    }

    private String getJSessionId(ResponseEntity<String> response) {
        List<String> cookies = response.getHeaders().get(COOKIE);
        return RegexUtils.replace(Iterables.getOnlyElement(cookies), ALL_EXCEPT_JSESSION_ID_PATTERN);
    }
}
