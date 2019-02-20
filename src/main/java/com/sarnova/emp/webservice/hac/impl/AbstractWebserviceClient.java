package com.sarnova.emp.webservice.hac.impl;

import com.sarnova.emp.util.RegexUtils;
import com.sarnova.emp.framework.FrameworkConfiguration;
import com.sarnova.emp.framework.rest.client.RestTemplateHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static com.sarnova.emp.util.RegexUtils.matchPattern;

public abstract class AbstractWebserviceClient {

    private static final String FIND_CSRF_PATTERN = "\\w{1,8}-\\w{1,4}-\\w{1,4}-\\w{1,4}-\\w{1,12}";

    @Autowired
    private RestTemplateHolder restTemplateHolder;
    @Autowired
    private FrameworkConfiguration frameworkConfiguration;

    protected String getCrfCode(String body) {
        return RegexUtils.matchPattern(body, FIND_CSRF_PATTERN);
    }

    protected RestTemplate getRestTemplate() {
        return restTemplateHolder.getRestTemplate();
    }

    protected String getHacUrl() {
        return frameworkConfiguration.getHacUrl();
    }
}
