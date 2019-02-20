package com.sarnova.emp.framework.rest.client;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateHolder {

    RestTemplate getRestTemplate();

    void setJSessionId(String jsessionId);

    void setCrfToken(String crfToken);

}
